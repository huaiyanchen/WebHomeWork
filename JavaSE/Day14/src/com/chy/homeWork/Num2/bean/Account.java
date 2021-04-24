package com.chy.homeWork.Num2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-20:44
 * @Since:jdk1.8
 * @Description: 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private long id;
    private double balance;
    private String password;

    public Account(double balance, String password) {
        this.balance = balance;
        this.password = password;
    }


}