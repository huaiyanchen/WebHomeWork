package com.chy.test;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-19:50
 * @Since:jdk1.8
 * @Description:TODO
 */

public class ShopTest {

    private Scanner scanner = new Scanner(System.in);
    private AdminOperation adminOperation = new AdminOperation();
    private CashierOperation cashierOperation = new CashierOperation();


    /**
     * 主菜单
     */
    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("欢迎使用超市管理系统");
            System.out.println("1、商品类型管理");
            System.out.println("2、商品管理");
            System.out.println("3、会员管理");
            System.out.println("4、购买管理");
            System.out.println("5、订单管理");
            System.out.println("6、排行统计管理");
            System.out.println("7.积分兑换");
            System.out.println("0、退出");
            System.out.println("请选择：");
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    if (adminOperation.adminLogin()) {
                        adminOperation.productTypeMenu();
                    }
                    break;
                case "2":
                    if (adminOperation.adminLogin()) {
                        adminOperation.productMenu();
                    }
                    break;
                case "3":
                    if (adminOperation.adminLogin()) {
                        adminOperation.vipMenu();
                    }
                    break;
                case "4":
                    if (cashierOperation.cashierLogin()) {
                        cashierOperation.buyOperation();
                    }
                    break;
                case "5":
                    if (cashierOperation.cashierLogin()) {
                        cashierOperation.orderManage();
                    }
                    break;
                case "6":
                    if (cashierOperation.cashierLogin()) {
                        cashierOperation.rank();
                    }
                    break;
                case "7":
                    if (cashierOperation.cashierLogin()) {
                        cashierOperation.jifen();
                    }
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    System.out.println("非法输入 请重新输入");
                    break;
            }
        }
    }
}