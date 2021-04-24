package com.chy.classWork;

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


    public boolean isRight(Adminstrator adminstrator) {
        if (userName.equals(adminstrator.getUserName()) && pwd == adminstrator.getPwd()) {
            return true;
        } else {
            return false;
        }
    }


}