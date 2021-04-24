package com.chy.homeWork.Num1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-20:23
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private int id;
    private int score;



    @Override
    public int compareTo(Student o) {
        return Math.min(this.id, o.getId());
    }
}
