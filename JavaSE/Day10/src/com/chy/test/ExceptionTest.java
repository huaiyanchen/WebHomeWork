package com.chy.test;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/3-10:32
 * @Since:jdk1.8
 * @Description:
 */
public class ExceptionTest {
    public void login()  {
        System.out.println("请输入:");
        int i = new Scanner(System.in).nextInt();
        if (i < 6) {
            throw new RuntimeException("太小了 ");
        }
    }

    public static void main(String[] args) {

        try {
            new ExceptionTest().login();
        } catch (Exception e) {
            System.out.println("异常是:" + e.getMessage());
        }

    }
}