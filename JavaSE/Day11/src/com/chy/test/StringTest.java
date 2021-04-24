package com.chy.test;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/5-16:24
 * @Since:jdk1.8
 * @Description: 
 */
public class StringTest {
    public void split() {
        String s = "java sm chy 25";
        String[] split = s.split(" ");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
    }
    public void subString() {
        String s = "javaWeb sm chy 25";
        System.out.println("s.substring(1, 5) = " + s.substring(1, 5));
    }

    public void indexOf() {
        String s = "javaWeb sm chy 25";
        System.out.println(s.indexOf("e",3));


    }

    public void charAt() {
        String s = "javaWeb sm chy 25";
        System.out.println(s.charAt(1));
    }

    public void stringBuffer() {
        StringBuffer sb = new StringBuffer();
        sb.append("123");
        System.out.println(sb);

    }
    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
       // stringTest.split();
//        stringTest.subString();
//        stringTest.indexOf();
//        stringTest.charAt();
        stringTest.stringBuffer();
    }

}