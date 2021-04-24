package com.chy.classWork.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-15:17
 * @Since:jdk1.8
 * @Description:
 */
@Data

@AllArgsConstructor

public class Animal {
    private String name;
    private String age;

    public void eat() {
        System.out.println(name+"eat");
    }
}