package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-17:26
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private int id;
}