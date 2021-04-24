package com.chy.homeWork.student.test;

import com.chy.homeWork.student.bean.Student;
import com.chy.homeWork.student.util.Base64Util;
import com.chy.homeWork.student.util.mD5Util;
import com.chy.homeWork.student.util.RandomUtils;

import java.util.Locale;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-19:49
 * @Since:jdk1.8
 * @Description:
 */
public class StudentTest {

    private Student student = new Student();

    private static Scanner sc = new Scanner(System.in);

    private  static void prt(String s) {
        System.out.println(s);
    }

    private static int choose;

    public void reg() {
        prt("---->注册");
        prt("请输入姓名:");
        String inputName = sc.next();

        prt("请输入密码:");
        String inputPwd = sc.next();

        prt("请输入身份证号:");
        String inputIdCard = sc.next();
        String encodeIdCard = "";

        String randomNumber = RandomUtils.randomInt(4);
        String encodeNumber = "";
        prt("请输入成绩:");
        String inputScore = sc.next();
        prt("请输入编码格式:1.base64 2.MD5");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                encodeIdCard = Base64Util.Base64Encode(inputIdCard);
                encodeNumber = Base64Util.Base64Encode(randomNumber);
                break;
            case 2:
                encodeIdCard = mD5Util.MD5Decode(inputIdCard);
                encodeNumber = mD5Util.MD5Encode(randomNumber);
            default:
                break;
        }
        student.setNumber(encodeNumber);
        student.setScore(inputScore);
        student.setIdCard(encodeIdCard);
        student.setPwd(inputPwd);
        student.setName(inputName);
        prt("注册成功");
    }

    public void login() {
        prt("----->登陆");
        if (student == null || student.getName() == null) {
            reg();
        }
        prt("请输入姓名:");
        String inputName = sc.next();

        prt("请输入密码:");
        String inputPwd = sc.next();


        if (student.getName().equals(inputName) && student.getPwd().equals(inputPwd)) {
            prt("登陆成功");
            show();
        }else {
            prt("账号密码错误:");
        }
    }

    public void show() {
        prt("请选择是否选择展示学号和身份证号y/n");
        String inputChoose = sc.next();
        prt("姓名:" + student.getName());
        if ("y".equals(inputChoose.toLowerCase(Locale.ROOT))) {

            String decodeIdCard = "";
            String decodeNumber = "";

            switch (choose) {
                case 1:
                    decodeNumber = Base64Util.Base64Decode(student.getNumber());
                    decodeIdCard = Base64Util.Base64Decode(student.getIdCard());
                    break;
                case 2:
                    System.out.println(student.getIdCard());
                    System.out.println(student.getNumber());
                    decodeIdCard = mD5Util.MD5Decode(student.getIdCard());
                    decodeNumber = mD5Util.MD5Decode(student.getNumber());
                default:
                    break;
            }

            prt("学号:" + decodeNumber);

            prt("身份证号:" + decodeIdCard);
        }
        prt("成绩:" + student.getScore());
    }

    public static void main(String[] args) {
        new StudentTest().login();
    }

}