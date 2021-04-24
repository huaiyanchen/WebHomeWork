package com.chy.homeWork.Num2.test;

import com.chy.homeWork.Num2.bean.BMW;
import com.chy.homeWork.Num2.bean.BenZ;
import com.chy.homeWork.Num2.bean.Car;
import com.chy.homeWork.Num2.bean.Driver;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:00
 * @Since:jdk1.8
 * @Description:
 */
public class CarTest {


    public static void main(String[] args) {
        Car bmw = new BMW();
        bmw.setColor("粉色");
        bmw.setNumberOfWheel(8);
        bmw.setName(bmw.getName());
        Driver driver = new Driver();
        driver.drive(bmw);


        Car benz = new BenZ();
        benz.setColor("黑色");
        benz.setNumberOfWheel(16);
        benz.setName(benz.getName());
        Driver driver2 = new Driver();
        driver2.drive(benz);

    }
}