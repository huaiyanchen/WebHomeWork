package com.chy.test;

import com.chy.bean.Car;
import com.chy.bean.Garage;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-17:39
 * @Since:jdk1.8
 * @Description: 
 */
/*
	车在跑的时候应该判断是否够四个轮子，如果够四个轮子可以跑起，否则送去修车厂维修。
 */

public class CarTest {

    public void judgeCar(Car car) {
        if (car.getNumberOfWheel() != 4) {
            System.out.println("送去修车厂维修");
            Garage garage = new Garage();
            garage.fix();
        } else {
            System.out.println("Car is OK");
        }

    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setNumberOfWheel(4);
        car.setColor("Blank");
        CarTest carTest = new CarTest();
        carTest.judgeCar(car);
    }
}