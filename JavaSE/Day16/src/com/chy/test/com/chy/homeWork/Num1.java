package com.chy.test.com.chy.homeWork;

import java.io.File;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-19:06
 * @Since:jdk1.8
 * @Description:1. 使用IO技术，开发出一个控制台的资源管理器！要求：从命令行输入一个路径！ 如果存在,将该目录下所有的文件和文件夹列举出来，如果不存在则输出不存在该路径。
 */

public class Num1 {
    public void show(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                show(file1);
            } else {
                System.out.println(file1.getName());
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        File file = new File(path);
        if (file.exists()) {
            new Num1().show(file);
        } else {
            System.out.println("路径错误,重新输入");
        }
    }
}