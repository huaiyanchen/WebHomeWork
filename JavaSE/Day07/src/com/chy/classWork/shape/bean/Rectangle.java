package com.chy.classWork.shape.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-16:41
 * @Since:jdk1.8
 * @Description:长方形
 */
@Data
public class Rectangle extends Shape {
    //长
    private double length;

    //宽
    private double width;

    public Rectangle(String name,  double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public void calcPerimeter() {
        setPerimeter((length + width) * 2);
    }

    @Override
    public void calcArea() {
        setArea(length * width);
    }
}