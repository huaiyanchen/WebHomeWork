package com.chy.homeWork.Num2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-18:53
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    //名字
    private String name;
    //颜色
    private String color;
    //轮子数量
    private int numberOfWheel;

    public void run(Car car) {
        System.out.println( "今天开"+car.getColor()+"的" + car.name);
    }

}