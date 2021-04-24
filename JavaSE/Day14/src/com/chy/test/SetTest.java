package com.chy.test;

import com.chy.bean.User;

import java.util.TreeSet;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-15:08
 * @Since:jdk1.8
 * @Description:
 */
public class SetTest {


    public static void test1() {
        TreeSet<User> treeSet = new TreeSet<>();
        User user1 = new User(1,"123");
        User user2 = new User(4,"234");
        User user3 = new User(2,"34");
        User user4 = new User(5,"34");
        System.out.println("hello");

        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        treeSet.add(user4);

        treeSet.forEach(c->{
            System.out.println(c.toString());
        });
    }
    public static void main(String[] args) {




    }
}