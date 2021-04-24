package com.chy.homeWork.Num3.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:20
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Print {
    //型号
    private String type;

    //打印
    public void print() {
        System.out.println("It can print");
    }
}