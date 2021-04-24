package com.chy.test;

import com.chy.bean.BuyCar;
import com.chy.bean.Commodity;
import com.chy.exception.UserException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/3-14:46
 * @Since:jdk1.8
 * @Description:
 */
public class CommodityTest {
    BuyCar buyCar = new BuyCar();
    public void buyComm() throws UserException {

        Commodity[] comm = new Commodity[]{
                new Commodity("啤酒", 0,8),
                new Commodity("花生", 2,5),
                new Commodity("瓜子", 3,6)
        };
        System.out.println("请输入要购买的商品:");
        String input = new Scanner(System.in).next();
        //购买商品的序号
        int cur = 0;
        boolean b = false;
        for (int i = 0; i < comm.length; i++) {
            if (comm[i].getName().equals(input)) {
                b = true;
                cur = i;
            }
        }
        if (b) {
            if (comm[cur].getNumber() > 0) {

                comm[cur].setNumber(comm[cur].getNumber() - 1);
                System.out.println("comm = " + Arrays.toString(comm));
                //购物车

                Commodity[] commodity = new Commodity[]{comm[cur]};
                buyCar.setCommodity(commodity);
                System.out.println("buyCar = " + buyCar);
            } else {
                throw new UserException("商品个数不足");
            }
        } else {
            throw new UserException("没有该商品");
        }
    }

    public static void main(String[] args) {
        try {
            while (true) {
                new CommodityTest().buyComm();
            }
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }

    }
}