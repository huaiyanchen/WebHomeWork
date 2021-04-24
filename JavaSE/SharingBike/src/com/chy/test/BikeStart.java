package com.chy.test;

import com.chy.bean.SharedBikeCompany;
import com.chy.bean.SharedBikeMgr;
import com.chy.service.BikeManager;
import com.chy.service.impl.BikeManagerImpl;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-16:00
 * @Since:jdk1.8
 * @Description:
 */
public class BikeStart {

    //输出
    static void prt(String s) {
        System.out.println(s);
    }

    //输入
    static Scanner sc = new Scanner(System.in);

    //menu
    public void startMenu() {
        prt("欢迎使用迷你共享单车管理系统");
        //调用初始化方法
        SharedBikeCompany[] initSharedCompanies = new SharedBikeMgr().init();
        boolean b = true;
        while (b) {
            BikeManager bikeManager = new BikeManagerImpl();
            prt("****************************");
            prt("\t\t1、投放Bike");
            prt("\t\t2、查看Bike");
            prt("\t\t3、删除Bike");
            prt("\t\t4、借出Bike");
            prt("\t\t5、归还Bike");
            prt("\t\t6、Bike排行榜");
            prt("\t\t7、退      出");
            prt("****************************");
            prt("请输入数字:");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    initSharedCompanies = bikeManager.addBikes(initSharedCompanies);
                    break;
                case 2:
                    bikeManager.showBikes(initSharedCompanies);
                    break;
                case 3:
                    initSharedCompanies = bikeManager.deleteBikes(initSharedCompanies);
                    break;
                case 4:
                    initSharedCompanies = bikeManager.rentBikes(initSharedCompanies);
                    break;
                case 5:
                    initSharedCompanies = bikeManager.backBikes(initSharedCompanies);
                    break;
                case 6:
                    bikeManager.sortBikes(initSharedCompanies);
                    break;
                case 7:
                    b = false;
                    break;
                default:
                    break;
            }
        }


    }
}