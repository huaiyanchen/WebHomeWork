package com.chy.ThreadDemo;

import com.chy.test.ThreadDemo;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/14-11:18
 * @Since:jdk1.8
 * @Description:
 */

public class RemoveThread implements Runnable {
    private ThreadDemo threadDemo;

    public RemoveThread(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    @Override
    public void run() {
        //remove
        while (true) {

            threadDemo.remove();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (list.size() > 0) {
//                System.out.println("移除了" + list.get(list.size()-1));
//                list.remove(list.size()-1);
//                System.out.println("剩余" + list.size());
//            }
        }
    }
}