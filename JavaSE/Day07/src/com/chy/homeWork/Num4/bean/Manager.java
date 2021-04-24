package com.chy.homeWork.Num4.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:44
 * @Since:jdk1.8
 * @Description: 
 */
@Data
public class Manager extends Stuff {
    //基本工资
    private double salary;
    //绩效工资
    private double performancePay;
    //年度分红
    private double annualDividend;

    public void action() {
        System.out.println("喝茶ing...");
    }


}