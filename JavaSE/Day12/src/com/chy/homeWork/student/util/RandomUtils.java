package com.chy.homeWork.student.util;

import java.util.Random;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-20:07
 * @Since:jdk1.8
 * @Description:
 */
public class RandomUtils {
    public static String randomInt(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}