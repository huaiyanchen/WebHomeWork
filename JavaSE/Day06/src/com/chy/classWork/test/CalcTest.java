package com.chy.classWork.test;

import com.chy.classWork.Calc;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:14
 * @Since:jdk1.8
 * @Description: 
 */
public class CalcTest {
    public static void main(String[] args) {
        Calc calc = new Calc(1, 1, "+");
        System.out.println("calc.calc() = " + calc.calc());

    }
}