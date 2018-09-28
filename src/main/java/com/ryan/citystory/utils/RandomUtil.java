package com.ryan.citystory.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import java.util.Random;
import java.util.UUID;

public class RandomUtil {
    
    private static StringBuilder builder = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static Random random = new Random();

    /**
     * 获取一个随机UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder(uuid.replace("-", ""));

        for (int i = 0; i < 4; i++) {
            sb.append(builder.charAt(random.nextInt(builder.length())));
        }
        return sb.toString();
    }

    public static String getMd5(String salt, String password){
        String hashAlgorithName = "MD5";
        int hashIterations = 1024;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        return obj.toString();
    }
}
