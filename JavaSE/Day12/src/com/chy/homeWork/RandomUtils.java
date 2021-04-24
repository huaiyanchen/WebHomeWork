package com.chy.homeWork;

import java.util.Random;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-17:56
 * @Since:jdk1.8
 * @Description:
 */
public class RandomUtils {

    /**
     *  可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）。
     */
    public String randomIntChar(int n) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int intChar = random.nextInt(3);
            switch (intChar) {
                case 0:
                    //0-9
                    char a = (char) (random.nextInt(10) + 48);
                    sb.append(a);
                    break;
                case 1:
                    //大写字母
                    char b = (char) (random.nextInt(26) + 65);
                    sb.append(b);
                    break;
                case 2:
                    //小写字母
                    char c = (char) (random.nextInt(26) + 97);
                    sb.append(c);
                    break;
                default:
                    break;

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("new RandomUtils().randomIntChar(5) = " + new RandomUtils().randomIntChar(10));
    }
}