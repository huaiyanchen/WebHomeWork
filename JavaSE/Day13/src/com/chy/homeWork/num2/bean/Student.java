package com.chy.homeWork.num2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-19:14
 * @Since:jdk1.8
 * @Description:学号、姓名、年龄、性别和联系方式。存入到集合中
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //学号
    private String id;
    //姓名
    private String name;
    //年龄
    private int age;
    //性别
    private String sex;
    //联系方式
    private String number;


}
