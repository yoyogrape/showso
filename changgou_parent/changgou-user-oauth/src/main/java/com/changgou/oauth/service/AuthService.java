package com.changgou.oauth.service;

import com.changgou.oauth.util.AuthToken;

/**
 *
 */
public interface AuthService {


    /**
     * 密码模式登录
     * @param username  消费者用户名
     * @param password  消费者密码
     * @param clientId  客户端id
     * @param clientSecret  客户端秘钥
     * @return
     */
    public AuthToken login(String username, String password, String clientId, String clientSecret);
}
