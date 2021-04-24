package com.chy.test.test;

import com.chy.test.thread.CallableDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-17:03
 * @Since:jdk1.8
 * @Description:
 */

public class CallableTest {
    public static void main(String[] args) {

        CallableDemo callableDemo = new CallableDemo();

        FutureTask futureTask1 = new FutureTask<>(callableDemo);
        FutureTask futureTask2 = new FutureTask<>(callableDemo);
        FutureTask futureTask3 = new FutureTask<>(callableDemo);

        Thread thread1 = new Thread(futureTask1,"线程1");
        Thread thread2 = new Thread(futureTask2,"线程2");
        Thread thread3 = new Thread(futureTask3,"线程3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}