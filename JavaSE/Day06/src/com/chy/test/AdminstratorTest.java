package com.chy.test;

import com.chy.bean.Adminstrator;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:43
 * @Since:jdk1.8
 * @Description:
 */
public class AdminstratorTest {
    public static void main(String[] args) {
        Adminstrator ad = new Adminstrator();
        Adminstrator ad2 = new Adminstrator("123", 123,0.1);
        ad.setUserName("123");
        ad.setPwd(123);
        ad.isRight(ad2);

    }
}