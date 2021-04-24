package chy.classWork.test;

import chy.classWork.inter.Calc;
import chy.classWork.inter.interImpl.CalcImpl;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-15:02
 * @Since:jdk1.8
 * @Description:
 */
public class CalcTest {
    public static void main(String[] args) {
        Calc calc = new CalcImpl();
        System.out.println("calc.sum(1, 2) = " + calc.sum(1, 2));

    }
}