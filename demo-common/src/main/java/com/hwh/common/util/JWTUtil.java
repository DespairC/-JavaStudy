package com.hwh.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author HwH
 * @date 2021/8/28 15:01
 * @description
 */
public class JWTUtil {

    /**
     * 盐值
     * */
    private static String SIGNATURE = "demo-test";

    /**
     * 生成jwt令牌
     * */
    public static String getToken(Map<String,String> map){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SIGNATURE));
        return token;
    }

    /**
     * 校验token
     * */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(token)).build().verify(token);
    }
}
