package com.chy.classWork.test;

import com.chy.classWork.Adminstrator;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:43
 * @Since:jdk1.8
 * @Description: 
 */
public class AdminstratorTest {

    static Adminstrator admin = new Adminstrator("chy", 123);

    public static void main(String[] args) {
        Adminstrator ad2 = new Adminstrator();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入密码:");
        int pwd = sc.nextInt();
        ad2.setUserName(name);
        ad2.setPwd(pwd);

        boolean right = ad2.isRight(admin);
        if (right) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登录失败");
        }
    }
}