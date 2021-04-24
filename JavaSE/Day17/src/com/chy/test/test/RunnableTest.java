package com.chy.test.test;

import com.chy.test.thread.RunnableDemo;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-17:03
 * @Since:jdk1.8
 * @Description: 
 */

public class RunnableTest {
    public static void main(String[] args) {

        RunnableDemo runnableDemo = new RunnableDemo();

        Thread threadRun1 = new Thread(runnableDemo, "綫程1");
        Thread threadRun2 = new Thread(runnableDemo, "綫程2");
        Thread threadRun3 = new Thread(runnableDemo, "綫程3");

        threadRun1.start();
        threadRun2.start();
        threadRun3.start();


    }
}