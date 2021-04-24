package com.chy.test;

import com.chy.bean.Rectangle;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-19:42
 * @Since:jdk1.8
 * @Description:
 */
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);

        System.out.println(rectangle);
        System.out.println("rectangle.area() = " + rectangle.area());
        System.out.println("rectangle.periMeter() = " + rectangle.periMeter());

    }
}