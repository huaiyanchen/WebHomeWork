package com.chy.homeWork;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-17:39
 * @Since:jdk1.8
 * @Description: 
 */
public class HomeWork {
    static Scanner sc = new Scanner(System.in);

    public void num1() {
        System.out.println("请输入一个字符串:");
        String next = sc.next();
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            int k = random.nextInt(next.length());
            stringBuffer.append(next.charAt(k));
        }
        System.out.println("验证码为:" + stringBuffer.toString());
    }

    public int num2(Date date1, Date date2) {
        int hour = (int) ((date2.getTime() - date1.getTime()) / (60 * 60L * 1000));
        return hour;
    }

    public Date num3(Date date, int day) {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
        time += day; // 相加得到新的毫秒数
        // time -= day; // 相减得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }

    public static void main(String[] args) {
        System.out.println("new Num().num3(new Date(),2) = " + new HomeWork().num3(new Date(), 2));

    }
}