package com.chy.homeWork.Num3.test;

import com.chy.homeWork.Num3.bean.BWPrint;
import com.chy.homeWork.Num3.bean.ColorPrint;
import com.chy.homeWork.Num3.bean.Print;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:25
 * @Since:jdk1.8
 * @Description:
 */
public class PrintTest {
    public void print(Print print) {
        if (print instanceof ColorPrint) {
            ColorPrint colorPrint = (ColorPrint) print;
            colorPrint.print();
        }
        if (print instanceof BWPrint) {
            BWPrint bwPrint = (BWPrint) print;
            bwPrint.print();
        }
    }

    public static void main(String[] args) {

        PrintTest printTest = new PrintTest();

        Print bWPrint = new BWPrint();
        bWPrint.setType("黑白");
        printTest.print(bWPrint);

        Print colorPrint = new ColorPrint();
        colorPrint.setType("color");
        printTest.print(colorPrint);

    }
}