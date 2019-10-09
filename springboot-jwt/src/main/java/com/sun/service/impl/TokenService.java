package com.sun.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sun.entity.User;

import org.springframework.stereotype.Service;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token="";
        // 将 user id 保存到 token 里面，以 password 作为 token 的密钥
        token= JWT.create().withAudience(user.getUid().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
