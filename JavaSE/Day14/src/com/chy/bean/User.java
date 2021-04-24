package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-15:09
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {
    private Integer age;
    private String name;


    @Override
    public int compareTo(User o) {
        return Math.min(this.age, o.getAge());
    }
}
