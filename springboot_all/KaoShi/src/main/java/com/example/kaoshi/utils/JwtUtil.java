package com.example.kaoshi.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    /** 证书签名标识 */
    private static final String SIGN = "xk";
    /** 加密密钥，至少256位，HS256要求 */
    private static final String SECRET = "springboot-jwt-course-demo-secret-key-for-student-teaching-2026-example-long-key-string";
    /** token过期时间，单位秒，原配置100秒 */
    private static final long EXPIRE_SECOND = 100;

    /**
     * 生成加密密钥 SecretKey
     * @return SecretKey
     */
    public static SecretKey generalKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    /**
     * 创建JWT Token，仅保存userId
     * @param userId 用户ID
     * @return jwt字符串
     */
    public static String createToken(Long userId) {
        SecretKey key = generalKey();
        long nowMs = System.currentTimeMillis();
        long expireMs = nowMs + EXPIRE_SECOND * 1000L;
        Map<String, Object> claim = new HashMap<>();
        claim.put("userId", userId);
        return Jwts.builder()
                .expiration(new Date(expireMs)) // exp 过期时间
                .subject(SIGN)                  // sub 签名标识
                .claims(claim)             // 自定义业务载荷数据
                .signWith(key)                  // 使用密钥签名
                .compact();
    }

    /**
     * 创建JWT Token，仅保存userId
     * @param userId 用户ID
     * @return jwt字符串
     */
    public static String createToken(Long userId, String username) {
        SecretKey key = generalKey();
        long nowMs = System.currentTimeMillis();
        long expireMs = nowMs + EXPIRE_SECOND * 1000L;
        Map<String, Object> claim = new HashMap<>();
        claim.put("userId", userId);
        claim.put("username", username);
        return Jwts.builder()
                .expiration(new Date(expireMs)) // exp 过期时间
                .subject(SIGN)                  // sub 签名标识
                .claims(claim)             // 自定义业务载荷数据
                .signWith(key)                  // 使用密钥签名
                .compact();
    }

    /**
     * 解析Token，得到Jws<Claims>
     * @param token jwt令牌字符串
     * @return Jws<Claims>
     * @throws JwtException 签名错误、过期、格式错误抛出异常
     */
    public static Jws<Claims> parseToken(String token) throws JwtException {
        SecretKey key = generalKey();
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
    }

    /**
     * 验证token是否合法（签名正确、未过期）
     * @param token jwt令牌
     * @return true有效；false无效
     */
    public static boolean verifyToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (ExpiredJwtException e) {
            // token过期
            return false;
        } catch (SecurityException e) {
            // 签名被篡改
            return false;
        } catch (MalformedJwtException | IllegalArgumentException e) {
            // token格式错误，空字符串
            return false;
        }
    }

    /**
     * 从token中获取自定义业务载荷
     * @param token token字符串
     * @return Claims载荷对象
     */
    public static Claims getClaims(String token) {
        return parseToken(token).getPayload();
    }


    /**
     * 从token获取userId
     * @param token jwt令牌
     * @return 成功返回userId；token无效/不存在userId返回null
     */
    public static Long getUserId(String token) {
        // token无效直接返回null
        if (!verifyToken(token)) {
            return null;
        }
        Claims claims = getClaims(token);
        Object userIdObj = claims.get("userId");
        // 类型校验，防止强转报错
        if (userIdObj instanceof Number) {
            return ((Number) userIdObj).longValue();
        }
        return null;
    }

}
