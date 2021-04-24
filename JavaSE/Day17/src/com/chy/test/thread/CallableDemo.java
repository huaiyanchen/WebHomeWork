package com.chy.test.thread;

import java.util.concurrent.Callable;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-17:10
 * @Since:jdk1.8
 * @Description: 
 */

public class CallableDemo implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "启动了");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +"----------------->"+ i);
        }
        System.out.println(Thread.currentThread().getName() + "关闭了");

        return Thread.currentThread().getName();
    }
}