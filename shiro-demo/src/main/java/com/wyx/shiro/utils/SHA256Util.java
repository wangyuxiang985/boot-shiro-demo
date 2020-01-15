package com.wyx.shiro.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @ClassName SHA256Util
 * @Description Sha-256加密工具
 * @Author yuxiang
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class SHA256Util {

    /**  私有构造器 **/
    private SHA256Util(){};
    /**  加密算法 **/
    public final static String HASH_ALGORITHM_NAME = "SHA-256";
    /**  循环次数 **/
    public final static int HASH_ITERATIONS = 15;
    /**  执行密码加密-采用SHA256和盐值加密 **/
    public static String sha256(String password, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }
}
