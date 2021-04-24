package com.chy.classWork.test;

import com.chy.classWork.Member;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-10:37
 * @Since:jdk1.8
 * @Description:
 */
public class MemberTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入会员号:");
        int number = sc.nextInt();
        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入积分:");
        int integral = sc.nextInt();
        Member m = new Member();
        m.setNumber(number);
        m.setUserName(name);
        m.setIntegral(integral);
        boolean right = m.isRight();
        if (right) {
            System.out.println("登陆成功");
            m.isLucky();
        } else {
            System.out.println("账号不合法");
        }
    }
}