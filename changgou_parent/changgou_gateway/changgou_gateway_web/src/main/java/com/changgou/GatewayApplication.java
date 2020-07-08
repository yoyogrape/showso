package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    //定义一个KeyResolver,创建用户唯一标识，使用IP作为唯一标识，来根据IP做限流操作
    @Bean
    public KeyResolver ipKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                System.out.println("...GatewayApplication...ipKeyResolver()...限制用户请求的IP：" + exchange.getRequest().getRemoteAddress().getHostName());
                return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
            }
        };
    }
}