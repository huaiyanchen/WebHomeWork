package com.chy.test.homwWork.Num3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-18:01
 * @Since:jdk1.8
 * @Description:
 */

public class TicketTest {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("chy", 0));
        userList.add(new User("123", 0));
        userList.add(new User("qwe", 0));
        userList.add(new User("asd", 0));
        userList.add(new User("zxc", 0));
        for (int i = 0; i < 350; i++) {
            User user = new User(("测试" + i), 0);
            userList.add(user);
        }

        for (User user : userList) {
            TicketThread ticketThread = new TicketThread(user);
            Thread thread = new Thread(ticketThread);
            thread.start();
        }
    }
}