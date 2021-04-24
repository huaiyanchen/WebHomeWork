package com.chy.homeWork.Num4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:35
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stuff {
    //编号
    private int number;
    //姓名
    private String name;

    //工作
    public void work() {

    }

    //工资结算
    public double calcSalary() {
        return 0.0;
    }


}