package com.chy.ThreadDemo;

import com.chy.test.ThreadDemo;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/14-11:18
 * @Since:jdk1.8
 * @Description: 
 */

public class AddThread implements Runnable {

    private ThreadDemo threadDemo;

    public AddThread(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    @Override
    public void run() {
        //add
        while (true) {
            threadDemo.add();

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (list.size() < 30) {
//                list.add("新增了一条");
//                System.out.println("新增了" + (list.size()) +"还剩"+list.size());
//            }
        }
    }
}