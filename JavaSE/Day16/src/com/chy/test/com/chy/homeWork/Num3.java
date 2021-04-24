package com.chy.test.com.chy.homeWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-19:28
 * @Since:jdk1.8
 * @Description: 从控制台进行输入用户名以及用户密码， 判断是否登录成功！要求准确的用户名和密码存在配置文件中
 */

public class Num3 {
    public static void main(String[] args){
        File file = new File("Day16\\resource\\user.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int read = -1;
            while (((read = fileInputStream.read()) != -1)) {
                stringBuilder.append((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] split = stringBuilder.toString().split(",");
        ///?????
        String userName = split[0].split(":")[1].trim();
        String pwd = split[1].split(":")[1].trim();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String uName = scanner.next();
        System.out.println("请输入密码:");
        String uPwd = scanner.next();
        if (userName.equals(uName) && pwd.equals(uPwd)) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }
}