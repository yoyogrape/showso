package com.changgou;
//import com.changgou.interceptor.FeignInterceptor;
//import com.changgou.user.config.TokenDecode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.dao"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run( UserApplication.class);
    }

    /**
     * TokenDecode工具类作用是解析请求头中的jwt令牌
     * 需要注册到spring容器中
     * @return
     */
//    @Bean
//    public TokenDecode tokenDecode() {
//        return new TokenDecode();
//    }

    /**
     * 获取消费者请求头中的jwt令牌放入到feign远程调用请求头中
     * 这里需要将它注册到spring容器中才会生效
     * @return
     */
//    @Bean
//    public FeignInterceptor feignInterceptor() {
//        return new FeignInterceptor();
//    }
}
