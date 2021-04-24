package com.chy.homeWork;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/5-18:53
 * @Since:jdk1.8
 * @Description: 
 */
public class HomeWork {
    static Scanner sc = new Scanner(System.in);

    public void num1() {
        System.out.println("请输入字符串:");
        String s = sc.next();
        //手动反转后的
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.charAt(i);
        }
        if (s1.equals(s)) {
            System.out.println("String 判断是 ");
        } else {
            System.out.println("String 判断不是");
        }
        //stringBuffer判断
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        sb.reverse();
        if (s.contentEquals(sb)) {
            System.out.println("StringBuffer 判断是 ");
        } else {
            System.out.println("StringBuffer 判断不是");
        }
    }

    public void num2() {
        String str = "aabbcc";
        String str1 = "abcabc";
        char[] by = str.toCharArray();
        char[] by1 = str1.toCharArray();
        Arrays.sort(by);//排序
        Arrays.sort(by1);
        if (Arrays.equals(by, by1)) {
            System.out.println("字符串一致");
        } else {
            System.out.println("字符串不一致");
        }
    }

    public void num3() {
        int[] arr = {1, 2, 3};
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ",");
        }
        //删除最后一个,
        sb.deleteCharAt(6);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void num4() {
        String input = sc.next();
        StringBuffer sb = new StringBuffer(input);
        sb.reverse();
        System.out.println(sb.toString());
    }

    public void num5() {
        String s = "asd asd ";
        s = s.replace(" ", "");
        System.out.println(s);
    }

    public void num6() {
        String s = "hanbasdnbafllgnbahjnbakqqqqlnbaxinbanba";
        String sb = new String("nba");
        String[] split = s.split(sb);
        int times = split.length - 1;
        System.out.println(times);
    }

    public void num7() {
        StringBuffer s = new StringBuffer();
        while (s.length() < 7) {
            s.append(sc.next());
        }
        int num = 0;

        // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
        for (int i = 0; i < s.length(); i++) {
            // 获取每个字符，判断是否是字符a
            if (s.charAt(i) == 'a') {
                // 累加统计次数
                num++;
            }
        }
        System.out.println(num);
    }

    public void num8() {
        String s = "woZUIaiAIxueSHAGNbianMAcheng";
        String small = "";
        String large = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //大写
            if (Character.isUpperCase(chars[i])) {
                large += chars[i];
            }
            if (Character.isLowerCase(chars[i])) {
                small += chars[i];
            }
        }
        System.out.println("small = " + small);
        System.out.println("large = " + large);
    }

    public void num9() {
        System.out.println("请输入账号:");
        String number = sc.next();
        System.out.println("请输入密码:");
        String pwd = sc.next();

        String numberRegex = "^[\\D]+$";
        String pwdRegex = "^(?![^a-zA-Z]+$)(?!\\D+$).{6,10}$";
        if (number.matches(numberRegex) && pwd.matches(pwdRegex)) {
            System.out.println("注册成功");
            System.out.println("number = " + number);
            System.out.println("pwd = " + pwd);
        } else {
            System.out.println("用户名密码不符合规范");
        }
    }

    public void num10() {
        String s = "我是chy,英文名是hyc;来自安徽,今年25;我的爱好有：LOL,MAD;我的的联系方式为 1888888888";

        System.out.println("s.contains(\"湖北省\") = " + s.contains("湖北省"));
        System.out.println("s.substring(14,23) = " + s.substring(14, 23));
        String[] split = s.split(";");

        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '我') {
                count++;
            }
        }
        System.out.println("count = " + count);
        System.out.println("s.replaceAll(\"我\", \"I\") = " + s.replaceAll("我", "I"));
    }

    public void num11() {
        StringBuilder sb = new StringBuilder("今天是星期一");
        sb.append("考试结果出来了，我及格了！");
        sb.insert(6, ",我现在心情很好.");
        sb.delete(23, 29);
        sb.append("我及格了！");
        System.out.println("sb.toString() = " + sb.toString());

    }



    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
//        homeWork.num1();
//        homeWork.num2();
        homeWork.num3();
//        homeWork.num4();
//        homeWork.num5();
//        homeWork.num6();
//        homeWork.num7();
//        homeWork.num8();
//        homeWork.num9();
//        homeWork.num10();
//        homeWork.num11();

    }

}