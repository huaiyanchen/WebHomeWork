package com.chy.test.homwWork.Num2;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-19:23
 * @Since:jdk1.8
 * @Description: 线程一：求出1-100之间的素数之和？
 */

public class ThreadDemo extends Thread {
    @Override
    public void run() {
        int sum = 2;
        for (int i = 3; i <= 100; i++) {
            boolean b = true;
            for (int j = i-1; j >1 ; j--) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                sum += i;
            }
        }
        System.out.println("ThreadDemo"+sum);
    }
}