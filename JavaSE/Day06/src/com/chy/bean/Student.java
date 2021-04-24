package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-17:50
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String number;
    private String sex;
    private Computer computer;

    public void eat() {
        System.out.println(this.name + "能吃饭");
    }

    public void study() {
        System.out.println(this.name + "能学习");
    }

    public boolean isHaveComputer(Computer computer) {
        if ("1".equals(computer.getRam())) {
            return true;
        } else {
            return false;

        }

    }
}