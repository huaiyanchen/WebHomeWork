package com.chy.test.homwWork.Num2;

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
        int sum = 0;
        for (int i = 100; i <= 200; i++) {
            boolean b = true;
            for (int j = i-1; j >1 ; j--) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                sum ++;
            }
        }
        System.out.println("RunnableDemo"+sum);
    }

}