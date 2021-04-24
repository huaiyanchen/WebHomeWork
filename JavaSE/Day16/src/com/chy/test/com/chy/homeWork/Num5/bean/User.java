package com.chy.test.com.chy.homeWork.Num5.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-11:47
 * @Since:jdk1.8
 * @Description: 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 2282433581245038462L;

    private Integer id;

    private String name;

    private Integer age;

}