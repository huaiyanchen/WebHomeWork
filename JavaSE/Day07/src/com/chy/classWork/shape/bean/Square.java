package com.chy.classWork.shape.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-16:39
 * @Since:jdk1.8
 * @Description:正方形
 */
@Data
@SuppressWarnings("all")
public class Square extends Shape {
    //边长
    private double lengthOfSide;

    public Square(String name, double lengthOfSide) {
        super(name);
        this.lengthOfSide = lengthOfSide;
    }

    @Override
    public void calcPerimeter() {
        setPerimeter(4 * lengthOfSide);
    }

    @Override
    public void calcArea() {
        setArea(lengthOfSide * lengthOfSide);
    }
}