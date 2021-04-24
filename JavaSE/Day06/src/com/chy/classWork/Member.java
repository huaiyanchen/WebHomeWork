package com.chy.classWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:26
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String userName;
    private int number;
    //积分
    private int integral;

    public boolean isRight() {
        if (String.valueOf(number).length() == 4) {
            show();
            return true;
        } else {
            return false;
        }
    }

    public void show() {
        System.out.println(toString());
    }

    public void isLucky() {
        if (1111 == number) {
            System.out.println("中奖了");
        } else {
            System.out.println("没中奖");
        }
    }

}