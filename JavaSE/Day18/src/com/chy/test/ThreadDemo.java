package com.chy.test;

import com.chy.ThreadDemo.AddThread;
import com.chy.ThreadDemo.RemoveThread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/14-14:33
 * @Since:jdk1.8
 * @Description: 
 */

public class ThreadDemo {
    public List<String> list = new ArrayList<>();

    public synchronized void add() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (list.size() > 30) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (list.size() < 30) {
            list.add("新增了一条");
            System.out.println("新增了" + (list.size()) + "还剩" + list.size());
        }
        this.notifyAll();
    }

    public synchronized void remove() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (list.size() > 0) {
            System.out.println("移除了" + list.get(list.size()-1));
            list.remove(list.size()-1);
            System.out.println("剩余" + list.size());
        }

        this.notifyAll();
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        AddThread addThread = new AddThread(threadDemo);
        RemoveThread removeThread = new RemoveThread(threadDemo);
        Thread thread1 = new Thread(addThread);
        Thread thread2 = new Thread(removeThread);

        thread1.start();
        thread2.start();
    }
}