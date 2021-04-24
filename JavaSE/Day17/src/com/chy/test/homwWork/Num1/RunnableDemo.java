package com.chy.test.homwWork.Num1;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-19:17
 * @Since:jdk1.8
 * @Description: 
 */

public class RunnableDemo implements Runnable {

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