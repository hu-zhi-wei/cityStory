package com.ryan.citystory.utils;

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
}
