package com.changgou.oauth.controller;

import com.changgou.oauth.service.AuthService;
import com.changgou.oauth.util.AuthToken;
import com.changgou.oauth.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * 消费者登录业务
 */
@Controller
@RequestMapping("/oauth")
public class AuthController {

    //从配置文件中读取客户端id, application.yml中读取
    @Value("${auth.clientId}")
    private String clientId;

    //从配置文件中读取客户端秘钥, application.yml中读取
    @Value("${auth.clientSecret}")
    private String clientSecret;

    //设置domain地址, 也就是什么样的域名可以访问cookie中的jti短令牌
    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    //jti短令牌在cookie中的生存时间
    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;

    @Autowired
    private AuthService authService;

    @Autowired
    private HttpServletResponse response;

    /**
     * 跳转到登录页面
     * defaultValue: 如果参数为null, 则设置成这个默认值
     * required: 这个参数必须有
     * @return
     */
    @GetMapping("/toLogin")
    public String toLogin(@RequestParam( value = "ReturnUrl", required = true, defaultValue = "http://www.changgou.com") String ReturnUrl, Model model) {
        model.addAttribute("ReturnUrl", ReturnUrl);
        return "login";
    }

    /**
     * 验证消费者用户名密码是否正确, 授权
     * @param username      消费者用户名
     * @param password      消费者密码
     * @param ReturnUrl     登录成功后跳转的路径
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "ReturnUrl") String ReturnUrl, Model model) {
        //1. 判断用户名如果为空跳转到登录页面
        if (StringUtils.isEmpty(username)) {
            //跳转到登录页面, 从新输入用户名, 密码
            return "redirect:http://web.changgou.com:8001/api/oauth/toLogin?ReturnUrl=" + ReturnUrl;
        }
        //2. 判断密码如果为空跳转到登录页面
        if (StringUtils.isEmpty(password)) {
            return "redirect:http://web.changgou.com:8001/api/oauth/toLogin?ReturnUrl=" + ReturnUrl;
        }
        //3. 调用service来完成登录授权
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);

        //登录失败跳转到登录页面重新登录
        if (StringUtils.isEmpty(authToken)) {
            return "redirect:http://web.changgou.com:8001/api/oauth/toLogin?ReturnUrl=" + ReturnUrl;
        }

        //4. 将jti短令牌存入消费者浏览器的cookie中
        CookieUtil.addCookie(response, cookieDomain, "/", "uid",
                authToken.getJti(), cookieMaxAge, false);

        //5. 登录成功, 跳转回原来的页面地址, ReturnUrl
        return "redirect:" + ReturnUrl;
    }
}
