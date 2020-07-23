package com.changgou.oauth.service;

import com.changgou.oauth.util.AuthToken;
import com.netflix.discovery.converters.Auto;
import com.sun.org.apache.bcel.internal.classfile.Method;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * springSecurityOauth2密码模式, 登录授权
 */
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * feign远程调用技术底层就使用这个东西, 可以发送get, post等请求
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * ribbon底层就使用了这个对象, 它可以从eureka注册中心中自动获取, 微服务的地址ip+端口
     * 因为现在是开发阶段, 等线上部署的时候不知道以后ip和端口号是多少, 所以对于请求路径
     * http://localhost:9200/oauth/token地址不能写死, 需要到注册中心中获取, 因为所有
     * 微服务启动后都要自动到eureka中进行注册
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 令牌在redis中的过期时间
     */
    @Value("${auth.ttl}")
    private int ttl;


    @Override
    public AuthToken login(String username, String password, String clientId, String clientSecret) {
        //1. 封装密码模式发送请求的地址, 根据服务名到eureka中要ip和端口
        ServiceInstance choose =  loadBalancerClient.choose("user-auth");
        //拼接成密码模式访问路径
        String url = choose.getUri() + "/oauth/token";

        //2. 封装密码模式请求头
        //使用httpbasic协议封装, 请求头包含客户端id, 和客户端秘钥, clientid和clientSecret
        MultiValueMap<String, String> head = new LinkedMultiValueMap<String, String>();
        head.add("Authorization", httpBasicHead(clientId, clientSecret));

        //3. 封装密码模式请求体
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        //代表密码模式
        body.add("grant_type", "password");
        //消费者用户名
        body.add("username", username);
        //消费者密码
        body.add("password", password);

        //4. 将请求头和请求体封装成请求对象
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, head);

        //5. 设置发送请求的时候, 如果出现400, 401算权限不足, 不算异常, 不抛出
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {

            /**
             * 从写异常处理方法, 如果遇到400, 401都算权限不足, 将异常吃掉, 不抛出, 其他异常调用父类中的方法正常处理
             * @param clientHttpResponse
             * @throws IOException
             */
            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
                if (clientHttpResponse.getRawStatusCode() != 400 && clientHttpResponse.getRawStatusCode() != 401) {
                    super.handleError(clientHttpResponse);
                }
            }
        });

        //6. 发送请求到springSecurityOauth2框架中进行处理
        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        //7. 获取响应体
        Map<String, String> responseBody = exchange.getBody();
        if (responseBody == null) {
            System.out.println("===========用户名密码验证出错, 响应体异常!!!==============");
            return null;
        }

        //8. 从响应体中获取jti短令牌, jwt长令牌, 以及刷新令牌, 判断这些令牌是否为空
        if (StringUtils.isEmpty(responseBody.get("access_token"))
                || StringUtils.isEmpty(responseBody.get("refresh_token"))
                || StringUtils.isEmpty(responseBody.get("jti"))) {
            System.out.println("===========登录失败, 短令牌, 长令牌, 刷新令牌都为空!!!==============");
            return null;
        }

        //9. 如果这些令牌不为空, jti作为key, jwt作为value存入redis中一份
        AuthToken authToken = new AuthToken();
        authToken.setJti(responseBody.get("jti"));
        authToken.setAccessToken(responseBody.get("access_token"));
        authToken.setRefreshToken(responseBody.get("refresh_token"));

        //存入redis中,使用字符串类型, authToken.getJti()是key, authToken.getAccessToken()是value
        //ttl是在redis中的过期时间, timeUnit是时间单位
        redisTemplate.boundValueOps(authToken.getJti()).set(authToken.getAccessToken(), ttl, TimeUnit.SECONDS);

        //10. 将短令牌, jwt长令牌, 刷新令牌封装成AuthToken实体类对象返回

        return authToken;
    }

    /**
     * 将客户端id和客户端秘钥使用httpBasic协议格式封装返回
     * @param clientId      客户端id
     * @param clientSecret  客户端秘钥
     * @return
     */
    private String httpBasicHead(String clientId, String clientSecret) {
        String str = clientId + ":" + clientSecret;
        //将客户端id和客户端秘钥进行base64编码
        byte[] encode = Base64Utils.encode(str.getBytes());
        //封装成httpBasic协议格式返回
        return "Basic " + new String(encode);

    }
}
