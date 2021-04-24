package com.chy.bean;

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

    public boolean isRight(Member member) {
        if (number == member.getNumber()) {
            return true;
        } else {
            return false;
        }
    }



}