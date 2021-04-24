package com.chy.homeWork.Num4.test;

import com.chy.homeWork.Num4.bean.GeneralStuff;
import com.chy.homeWork.Num4.bean.Manager;
import com.chy.homeWork.Num4.bean.Salary;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:50
 * @Since:jdk1.8
 * @Description:
 */
public class StuffTest {
    public static void main(String[] args) {
        Salary salary = new Salary();
        GeneralStuff generalStuff = new GeneralStuff();
        generalStuff.setSalary(1000);
        System.out.println("salary.calcSalary(generalStuff) = " + salary.calcSalary(generalStuff));
        generalStuff.action();

        Manager manager = new Manager();
        manager.setSalary(12345);
        manager.setAnnualDividend(12312);
        manager.setPerformancePay(12332);
        System.out.println("salary.calcSalary(manager) = " + salary.calcSalary(manager));
        manager.action();

    }
}