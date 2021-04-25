package com.chy.test;

import com.chy.constants.UserConstants;
import com.chy.service.OrderService;
import com.chy.service.ProductService;
import com.chy.service.impl.OrderServiceImpl;
import com.chy.service.impl.ProductServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-15:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CashierOperation {
    private Scanner scanner = new Scanner(System.in);
    private OrderService orderService = new OrderServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    /**
     * 收银员登陆
     *
     * @return
     */
    public boolean cashierLogin() {
        System.out.println("您的操作为收银员权限,请先登录");
        System.out.println("请输入账号:");
        String user = scanner.next();
        System.out.println("请输入密码:");
        String pwd = scanner.next();
        if (user.equals(UserConstants.CASHIERUSER_ID) && pwd.equals(UserConstants.CASHIERUSER_PWD)) {
            System.out.println("您的身份是收银员身份:");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 购买
     */
    public void buyOperation() {
        //map 购物车  key --> pid  value--> pnum
        Map<Integer, Integer> buyCar = new HashMap<>();
        boolean b = true;
        while (b) {
            System.out.println("请输入选择");
            System.out.println("1.添加商品\n2.修改商品数量\n3.删除购物车中的商品\n4.展示购物车商品列表\n5.确定购买\n0.退出 ");
            switch (scanner.next()) {
                case "1":
                    orderService.addProduct(buyCar);
                    break;
                case "2":
                    orderService.updateProduct(buyCar);
                    break;
                case "3":
                    orderService.deleteProduct(buyCar);
                    break;
                case "4":
                    orderService.showProduct(buyCar);
                    break;
                case "5":
                    if (!buyCar.isEmpty()) {
                        orderService.pay(buyCar);
                    } else {
                        System.out.println("空车 不发车!!!");
                    }
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    System.out.println("非法输入~~~~~~");
                    break;
            }
        }
    }

    /**
     * 订单查询
     */
    public void orderManage() {
        boolean b = true;
        while (b) {
            System.out.println("请输入按照什么查询\t1.商品编号\t2.会员编号\t3.商品编号和会员编号\t0.退出 ");
            switch (scanner.next()) {
                case "1":
                    orderService.orderManageByPid();
                    break;
                case "2":
                    orderService.orderManageByVid();
                    break;
                case "3":
                    orderService.orderManageByPidVid();
                    break;
                case "0":
                    b = false;
                default:
                    System.out.println("非法输入");
                    break;
            }
        }
    }

    /**
     * 订单排行
     */
    public void rank() {
        boolean b = true;
        while (b) {
            System.out.println("1.查看排序 0.返回上一级");
            switch (scanner.next()) {
                case "1":
                    orderService.rankByPM();
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 积分兑换
     */
    public void jifen() {
        productService.jifen();
    }
}