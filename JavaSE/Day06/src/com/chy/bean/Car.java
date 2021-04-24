package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-17:34
 * @Since:jdk1.8
 * @Description:
 */

/*
	使用java来描述车class，车都具备轮子数、颜色 、与跑的行为，
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int numberOfWheel;
    private String color;

    public void run() {
        System.out.println("Car can run!");

    }
}