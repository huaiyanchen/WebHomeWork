package com.chy.test.homwWork.Num2;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-19:22
 * @Since:jdk1.8
 * @Description: 2、
 * 使用多线程实现，求素数：【线程一和线程二使用两个线程的方式来实现】
 * (1)	要求创建两个线程来求素数！
 * (2)	线程一：求出1-100之间的素数之和？
 * (3)	线程二：求出100-200之间素数的个数？
 */

public class Num2 {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        RunnableDemo runnableDemo = new RunnableDemo();
        Thread runnableThread = new Thread(runnableDemo);

        threadDemo.start();
        runnableThread.start();
    }
}