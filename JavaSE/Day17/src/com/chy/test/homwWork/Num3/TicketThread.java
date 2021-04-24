package com.chy.test.homwWork.Num3;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-17:39
 * @Since:jdk1.8
 * @Description: 
 */

public class TicketThread implements Runnable {

    // 构造方法 注入user
    private User user;

    public TicketThread(User user) {
        this.user = user;
    }

    //总票数
    private static int ticketNum = 1000;
    //记录锁中的票数
    int count = 0;

    @Override
    public void run() {
        while (true) {
            boolean b = buy2User();
            if (!b) {
                break;
            }
        }
    }

    //购买
    private synchronized boolean buy() {

        if (ticketNum <= 0) {
            System.out.println("----------->票抢完了");
            return false;
        }
        count++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---------->买第" + (ticketNum--) + "张票");
        if (count >= 3) {
            count = 0;
            return false;
        }
        return true;
    }

    //购买
    private synchronized boolean buy2User() {
        if (ticketNum <= 0) {
            System.out.println(user.getName() + "-------------->票抢完了");
            return false;
        }
        if (user.getNum() >= 3) {
            System.out.println(user.getName() + "------------>够三张票");
            return false;
        } else {
            user.setNum(user.getNum() + 1);
            System.out.println(user.getName() + "---------->买第" + (ticketNum--) + "张票");
        }
        return true;
    }

}