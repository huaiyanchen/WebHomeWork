package com.chy.test.com.chy.homeWork;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-19:57
 * @Since:jdk1.8
 * @Description:
 * 实现一个随机点名的功能。
 * (1)	在文件中存储所有的学生名字。
 * (2)	然后将数据读取存储到集合中。
 * (3)	然后再通过这个集合产生一个随机数。
 * (4)	再取值！
 */

public class Num4 {
    public static void main(String[] args) {
        File file = new File("Day16\\resource\\name.txt");
        char[] bytes = new char[20];
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(file)) {
            int read;
            while ((read = fileReader.read(bytes, 0, bytes.length)) != -1) {
                stringBuffer.append(new String(bytes),0,read);
            }
            String[] split = stringBuffer.toString().split(",");
            int random = new Random().nextInt(split.length);
            System.out.println("点到的人是:" + split[random]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}