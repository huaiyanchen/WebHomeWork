package com.chy.classWork.shape.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-16:36
 * @Since:jdk1.8
 * @Description:yuan
 */
@Data
public class Circle extends Shape {
    //半径
    private double radius;


    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }


    @Override
    public void calcPerimeter() {
        this.setPerimeter(2 * 3.14 * radius);
    }

    @Override
    public void calcArea() {
        this.setArea(3.14 * radius * radius);
    }
}