package com.chy.classWork.shape.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-16:33
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shape {
    //名称
    private String name;
    //周长
    private double perimeter;
    //面积
    private double area;

    public Shape(String name) {
        this.name = name;
    }


    /*
    求周长
     */
    public void calcPerimeter() {

    }

    /*
     求面积
    */
    public void calcArea() {

    }
}