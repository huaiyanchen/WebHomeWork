package com.chy.test.thread;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-17:00
 * @Since:jdk1.8
 * @Description: 
 */

public class ThreadDemo extends Thread {

    public ThreadDemo() {
    }

    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动了");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +"----------------->"+ i);
        }
        System.out.println(Thread.currentThread().getName() + "关闭了");
    }
}