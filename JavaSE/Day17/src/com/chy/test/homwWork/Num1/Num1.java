package com.chy.test.homwWork.Num1;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-19:11
 * @Since:jdk1.8
 * @Description: 1、创建两个线程，每个线程打印出线程名字后再睡眠，
 * 给其它线程以执行的机会，主线程也要打印出线程名字后再睡眠，
 * 每个线程前后共睡眠5次。要求分别采用从Thread中继承和实现Runnable接口两种方式来实现程序。（即写两个程序）。
 */

public class Num1 {
    public void testThreadDemo() {
        ThreadDemo threadDemo1 = new ThreadDemo("线程1");
        ThreadDemo threadDemo2 = new ThreadDemo("线程2");

        threadDemo1.start();
        threadDemo2.start();
    }

    public void testRunnableDemo() {
        RunnableDemo runnableDemo = new RunnableDemo();

        Thread thread1 = new Thread(runnableDemo, "线程1");
        Thread thread2 = new Thread(runnableDemo, "线程2");
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Num1().testRunnableDemo();

    }
}