package com.chy.test;

import java.io.*;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-15:13
 * @Since:jdk1.8
 * @Description:
 */

public class FileStreamTest {
    static Scanner scanner = new Scanner(System.in);

    //单个读取

    public void read1(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int read = -1;
        StringBuilder sb = new StringBuilder();
        while ((read = fileInputStream.read()) != -1) {
            sb.append((char) read);

        }
        System.out.println(sb);
        fileInputStream.close();
    }

    //一次性读取
    public void read2(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStream.read(bytes);
        String s = new String(bytes);
        System.out.println(s);
        fileInputStream.close();
    }

    //多次读取  但是append会有覆盖问题
    public void read3(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();

        int len = 0;
        while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            sb.append(new String(bytes), 0, len);
        }
        System.out.println(sb);
        fileInputStream.close();
    }

    //写
    public void write(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        System.out.println("请输入:");
        String s = scanner.next();
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();

    }


    //复制
    public void copy(File file1, File file2) throws IOException {
        long l = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        byte[] bytes = new byte[1024];

        int len = 0;
        while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {

            fileOutputStream.write(bytes,0,len);
        }

        fileInputStream.close();
        fileOutputStream.close();
        long l2 = System.currentTimeMillis();
        int  t = (int) ((int)l2 - l);
        System.out.println("普通"+t);
    }


    //高效字符流
    public void copy2(File file1, File file2) throws IOException {
        long l = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        byte[] bytes = new byte[1024];

        int len = 0;
        while ((len = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {

            bufferedOutputStream.write(bytes,0,len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();
        long l1 = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        int  t = (int) ((int)l1 - l);
        System.out.println("高效" + t);

    }


    public static void main(String[] args) throws IOException {
        File file1 = new File("Day16\\resource\\1.txt");
        File file2 = new File("1.txt");
//        new FileStreamTest().read1(file);
//        new FileStreamTest().read2(file);
//        new FileStreamTest().read3(file);
//        new FileStreamTest().write(file);
        new FileStreamTest().copy(file1, file2);
        new FileStreamTest().copy2(file1, file2);

    }


}