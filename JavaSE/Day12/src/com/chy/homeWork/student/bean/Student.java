package com.chy.homeWork.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-19:40
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //姓名
    private String name;
    //密码
    private String pwd;
    //学号
    private String number;
    //身份证号
    private String idCard;
    //成绩
    private String score;
}