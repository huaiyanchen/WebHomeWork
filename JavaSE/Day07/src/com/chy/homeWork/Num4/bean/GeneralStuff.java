package com.chy.homeWork.Num4.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:41
 * @Since:jdk1.8
 * @Description: 
 */
@Data

public class GeneralStuff extends Stuff {
    //工资
    private double salary;
    //职称
    private String title;

    public void action() {
        System.out.println("打酱油ing...");

    }


}