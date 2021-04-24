package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:25
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adminstrator {
    private String userName;
    private int pwd;
    private double discount;


    public void show() {
        System.out.println("Administrator{" +
                "userName='" + userName + '\'' +
                "discount='" + discount + '\'' +
                ", pwd=" + pwd +
                '}');
    }

    public boolean isRight(Adminstrator adminstrator) {
        if (userName.equals(adminstrator.getUserName()) && pwd == adminstrator.getPwd()) {
            show();
            return true;
        } else {
            return false;
        }
    }
    public boolean isLucky() {
        if ("111".equals(userName)) {
            return true;
        } else {
            return false;
        }
    }

    public double discount() {
        return 0.1;
    }
}