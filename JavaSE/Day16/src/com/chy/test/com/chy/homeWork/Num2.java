package com.chy.test.com.chy.homeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-19:19
 * @Since:jdk1.8
 * @Description: 从控制台输入一些字符串，并将该类信息保存到日志文件”log.txt”中去。
 */

public class Num2 {
    public static void main(String[] args) {
        File file = new File("Day16\\resource\\log.txt");
        //判断存在
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("請輸入");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        FileOutputStream fileOutputStream = null;
        try {
             fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(input.getBytes());
                System.out.println("存贮成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}