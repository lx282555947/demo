package com.lixin.token;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenUtils {

    private static String SECRET_KEY = "secret";

    /**
     * 用对称加密，HMAC256 获取token
     * @param mobile
     * @return
     */
    public static String createToken(String mobile) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            token = JWT.create()
//                    .withAudience(username)
                    //过期时间
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60))
                    .withClaim("mobile", mobile)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }
        return token;
    }

    /**
     * 使用HMAC256进行解密
     * @param token
     * @param mobile
     * @return
     */
    public static boolean verifyToken(String token, String mobile) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("mobile", mobile)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(JSON.toJSONString(jwt));
            return true;
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args){
        String mobile = "13261989780";
        String token = createToken(mobile);
        System.out.println(token);
        boolean isAccess = verifyToken(token, mobile);
        System.out.println(isAccess);
    }
}
