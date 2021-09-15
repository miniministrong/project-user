package com.ebiz.user.commons.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author dhl
 * @datetime 2021/8/13  11:59
 */
public class JwtUtils {
    /**
     * 超时时间
     */
    private static final long TIME_OUT_MS = 1000 * 60 * 30;
    /**
     * 加密方式
     */
    private static final String ENCRYPT ="wqw123";
    /**
     * 算法
     */
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(ENCRYPT);

    /**
     * 生成签名，30min后过期
     * @param id
     * @return
     */
    public static String sign(int id){
        Date date = new Date(System.currentTimeMillis() + TIME_OUT_MS);
        return JWT.create()
                .withClaim("sid", id)
                .withExpiresAt(date)
                .sign(ALGORITHM);
    }

    /**
     * 验证token是否正确
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取token中的信息
     * @param token
     * @param name
     * @return
     */
    public static String getClaimByName(String token, String name) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(name).asString();
    }
}