package com.chy.homeWork.Num4.bean;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:48
 * @Since:jdk1.8
 * @Description: 
 */
public class Salary {
    public double calcSalary(Manager manager) {
        double salary = manager.getSalary() + manager.getAnnualDividend() + manager.getPerformancePay();
        return salary;
    }

    public double calcSalary(GeneralStuff generalStuff) {
        return generalStuff.getSalary();
    }
}