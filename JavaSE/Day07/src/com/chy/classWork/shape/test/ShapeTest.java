package com.chy.classWork.shape.test;

import com.chy.classWork.shape.bean.Circle;
import com.chy.classWork.shape.bean.Rectangle;
import com.chy.classWork.shape.bean.Shape;
import com.chy.classWork.shape.bean.Square;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-16:44
 * @Since:jdk1.8
 * @Description: com.chy.test
 */
public class ShapeTest {

    /**
     * @Author chy
     * @Date 2021/3/30 17:27
     * @Description 多态
     * @Since version-1.0
     */
    public void showShape(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            circle.calcArea();
            circle.calcPerimeter();
            System.out.println(circle.getPerimeter() + " " + circle.getArea());
        }
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            rectangle.calcPerimeter();
            rectangle.calcArea();
            System.out.println(rectangle.getPerimeter() + " " + rectangle.getArea());
        }

        if (shape instanceof Square) {
            Square square = (Square) shape;
            square.calcPerimeter();
            square.calcArea();
            System.out.println(square.getPerimeter() + " " + square.getArea());
        }


    }


    public static void main(String[] args) {
        ShapeTest shapeTest = new ShapeTest();

        Shape circle = new Circle("圆", 3.0);
        /*
         * @Date 2021/3/30 17:28
         * @Description 继承
         */
        circle.calcArea();

        shapeTest.showShape(circle);

        Shape rectangle = new Rectangle("长方形", 3.3, 4.4);
        shapeTest.showShape(rectangle);


        Shape square = new Square("正方形", 5);
        shapeTest.showShape(square);


    }
}