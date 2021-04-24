package com.chy.test;

import com.chy.bean.BankUser;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-15:13
 * @Since:jdk1.8
 * @Description: bank
 */
public class BankUserTest {
    static Scanner sc = new Scanner(System.in);

    public void login(BankUser bankUser) throws Exception {
        System.out.println("请输入账号:");
        String No = sc.next();
        System.out.println("请输入密码:");
        String pwd = sc.next();

        if (bankUser.userNo.equals(No) && bankUser.userPwd.equals(pwd)) {
            System.out.println("登陆成功");
            menu(bankUser);
        } else {
            throw new Exception("账号密码不正确");
        }
    }

    public void withDraw(BankUser bankUser) throws Exception {
        System.out.println("请输入取款的金额：");
        int inputMoney = sc.nextInt();
        if (inputMoney % 2 != 0 || inputMoney < 100 || inputMoney > 10000) {
            throw new Exception("请输入合法的金额!");
        } else if (inputMoney < bankUser.getUserMoney()) {
            throw new Exception("余额不足!");
        }
        //减
        bankUser.userMoney = bankUser.userMoney - inputMoney;
        bankUser.date = "2021-03-30";
    }

    public void save(BankUser bankUser) throws Exception {
        System.out.println("请输入存款的金额：");
        int inputMoney = sc.nextInt();
        if (inputMoney % 100 != 0 || inputMoney < 100 || inputMoney > 10000) {
            throw new Exception("请输入合法的金额!");
        }
        //加
        bankUser.userMoney = bankUser.userMoney + inputMoney;
        bankUser.date = "2021-03-31";
    }

    public void menu(BankUser bankUser) throws Exception {
        boolean b = true;
            while (b) {
                System.out.println("1、取款 2、存款 3、查询余额 4、退出");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        withDraw(bankUser);
                        break;
                    case 2:
                        save(bankUser);
                        break;
                    case 3:
                        show(bankUser);
                        break;
                    case 4:
                        System.out.println("谢谢使用！");
                        b = false;
                        break;
                    default:
                        break;
                }
            }



    }

    public void show(BankUser bankUser) {
        System.out.println("账号：\t" + bankUser.userNo + "余额：\t" + bankUser.userMoney + "最后操作时间：" + bankUser.date);
    }


    public static void main(String[] args) {
        BankUser bankUser = new BankUser();
        bankUser.setUserNo("3306");
        bankUser.setUserMoney(123);
        bankUser.setUserPwd("123456");
        bankUser.setDate("2020-2-2");
        try {
            new BankUserTest().login(bankUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}