package com.chy.homeWork.Num1.bean;

import lombok.*;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-17:46
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    //编号
    private int number;
    //姓名
    private String name;
    //教授课程
    private String className;

    public void selfIntroduction() {
        System.out.println("大家好 我的名字是" + name + "我教的课程是" + className);
    }

    public void teacherRating() {
        System.out.println(name + "进行评级");
    }

}