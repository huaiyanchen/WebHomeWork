package com.chy.test;

import java.io.File;
import java.io.IOException;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-11:32
 * @Since:jdk1.8
 * @Description:TODO
 */

public class FileTest {

    //循环读取文件
    public void show(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                System.out.println(file1);
                show(file1);
            }
            if (file1.toString().endsWith(".avi")) {
                System.out.println(file1);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

    }
}