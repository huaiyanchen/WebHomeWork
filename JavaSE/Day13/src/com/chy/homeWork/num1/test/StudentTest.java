package com.chy.homeWork.num1.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-18:05
 * @Since:jdk1.8
 * @Description:
 */
public class StudentTest {
    ArrayList<Integer> list = new ArrayList();
    //录入
    private void add() {
        System.out.println("请输入录入的人数:");
        int num = new Scanner(System.in).nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("请输入第" + (i + 1) + "个人的分数:");
            int score = new Scanner(System.in).nextInt();
            list.add(score);
        }
    }

    public void show() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个人的分数为:" + list.get(i));
        }
    }

    public void calc() {
        //求和
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        //平均值
        int average = sum / list.size();

        Object[] objects = list.toArray();
        Arrays.sort(objects);
        System.out.println("总成绩 " + sum);
        System.out.println("平均分 " + average);
        System.out.println("最小值" + objects[0]);
        System.out.println("最大值" + objects[objects.length-1]);

    }


    public void showArray() {
        Object[] objects = list.toArray();
        Arrays.sort(objects);
        for (int i = 0; i < objects.length; i++) {
            System.out.println("第" + (i + 1) + "个人的分数为:" + objects[i]);
        }
    }
    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest();
        studentTest.add();
        studentTest.show();
        studentTest.calc();
        studentTest.showArray();

    }
}