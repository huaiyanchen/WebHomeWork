package com.chy.test.com.chy.homeWork.Num5.test;

import com.chy.test.com.chy.homeWork.Num5.bean.User;
import com.chy.test.com.chy.homeWork.Num5.service.Impl.WorkServiceImpl;
import com.chy.test.com.chy.homeWork.Num5.service.WorkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12
 * @Since:jdk1.8
 * @Description:
 */

public class WorkAction {
    static Scanner scanner = new Scanner(System.in);
    private List<User> userList;

    public WorkAction() {
        userList = new ArrayList<>(10);
        userList.add(new User(101, "blank", 23));
        userList.add(new User(102, "white", 24));
        userList.add(new User(103, "green", 25));
        userList.add(new User(104, "chy", 26));
    }

    public void menu() {
        WorkService workService = new WorkServiceImpl();
        System.out.println("请输入:");
        System.out.println("1.添加,2.根据编号删除,3.根据编号修改,4.显示,其他退出");
        String choose = scanner.next();
        switch (choose) {
            case "1":
                workService.addUser(userList);
                menu();
                break;
            case "2":
                System.out.println("請輸入删除的id");
                int id = scanner.nextInt();
                workService.deleteById(id,userList);
                menu();
                break;
            case "3":
                workService.updateUser(userList);
                menu();
                break;
            case "4":
                workService.findAllUser(userList);
                menu();
                break;
            default:
                break;
        }

    }

}