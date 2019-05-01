package com.springboot.jpa_demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class GetToken {

    public static String getToken(int id,String password){
        String token="";
        //Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
        //withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
        token= JWT.create().withAudience(String.valueOf(id))
                .sign(Algorithm.HMAC256(password));

        return token;
    }

}
