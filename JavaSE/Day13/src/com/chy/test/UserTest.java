package com.chy.test;

import com.chy.bean.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-17:28
 * @Since:jdk1.8
 * @Description:
 */
public class UserTest {

   static Scanner sc = new Scanner(System.in);

    //增
    private  ArrayList<User> add( ArrayList<User> arrayList){
        User user1 = new User("chy", 23, 123);
        User user2 = new User("hyc", 12, 124);
        User user3 = new User("yhc", 13, 125);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        return arrayList;
    }

    //删
    private  ArrayList<User> delete( ArrayList<User> arrayList) {
        System.out.println("请输入要删除的用户id");
        int deleteId = sc.nextInt();
        User deleteUser = getUser(deleteId, arrayList);
        deleteUser.setId(deleteId);
        arrayList.remove(deleteUser);
        return arrayList;

    }

    //改
    private ArrayList<User> update(ArrayList<User> arrayList) {
        System.out.println("请输入要修改的用户id");
        int updateId = sc.nextInt();
        User updateUser = getUser(updateId, arrayList);
        System.out.println("请输入修改用户的姓名:");
        String name = sc.next();
        System.out.println("请输入修改用户的年龄:");
        int age = sc.nextInt();

        updateUser.setAge(age);
        updateUser.setName(name);
        arrayList.set(arrayList.indexOf(updateUser), updateUser);
        return arrayList;
    }



    public static void main(String[] args) {
        ArrayList<User> arrayList = new ArrayList<>();
        UserTest userTest = new UserTest();
        userTest.add(arrayList);
        userTest.delete(arrayList);
        userTest.update(arrayList);
        //查
        System.out.println("arrayList = " + arrayList);
    }

    /**
     *查找用户
     */
    private static User getUser(int id, ArrayList<User> arrayList) {
        User returnUser = null;
        for (User user : arrayList) {
            if (user.getId() == id) {
                returnUser = user;
            }
        }
        return returnUser;

    }




}