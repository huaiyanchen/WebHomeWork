package com.chy.test.homwWork.Num1;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-19:08
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

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}