package com.chy.test.test;

import com.chy.test.thread.ThreadDemo;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-17:03
 * @Since:jdk1.8
 * @Description: 
 */

public class ThreadTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo("线程1");
        ThreadDemo threadDemo2 = new ThreadDemo("线程2");
        ThreadDemo threadDemo3 = new ThreadDemo("线程3");

        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
    }
}