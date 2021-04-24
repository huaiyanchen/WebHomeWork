package com.chy.classWork;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-11:08
 * @Since:jdk1.8
 * @Description: 
 */
public class Salary {
    public void Salary(SE se) {
        System.out.println(se.getName()+(se.getSalary()+se.getBonus()));
    }
    public void Salary(PE pe) {
        System.out.println(pe.getName()+(pe.getSalary()));
    }
}