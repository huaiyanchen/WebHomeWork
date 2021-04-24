package com.chy.homeWork.Num4.test;

import com.chy.homeWork.Num4.bean.Department;
import com.chy.homeWork.Num4.bean.GeneralStuff;
import com.chy.homeWork.Num4.bean.Manager;
import com.chy.homeWork.Num4.bean.Salary;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:56
 * @Since:jdk1.8
 * @Description: 
 */
public class DepartmentTest {
    public static void main(String[] args) {


        Manager manager1 = new Manager();
        manager1.setSalary(12345);
        manager1.setAnnualDividend(12312);
        manager1.setPerformancePay(12332);


        GeneralStuff generalStuff1 = new GeneralStuff();
        generalStuff1.setTitle("area1");
        generalStuff1.setSalary(1000);
        GeneralStuff generalStuff2 = new GeneralStuff();
        generalStuff2.setTitle("area2");
        generalStuff2.setSalary(1001);
        GeneralStuff generalStuff3 = new GeneralStuff();
        generalStuff3.setTitle("area3");
        generalStuff3.setSalary(1002);
        GeneralStuff generalStuff4 = new GeneralStuff();
        generalStuff4.setTitle("area4");
        generalStuff4.setSalary(1003);

        GeneralStuff[] generalStuffs = new GeneralStuff[4];
        generalStuffs[0] = generalStuff1;
        generalStuffs[1] = generalStuff2;
        generalStuffs[2] = generalStuff3;
        generalStuffs[3] = generalStuff4;

        Department department1 = new Department();
        department1.setManager(manager1);
        department1.setGeneralStuffs(generalStuffs);
        System.out.println("department1 = " + department1);


        Salary salary = new Salary();
        //经理工资
        double manageSalary = salary.calcSalary(department1.getManager());
        //普通员工工资
        double stuffSalary = 0.0;
        for (GeneralStuff generalStuff : department1.getGeneralStuffs()) {
            stuffSalary += generalStuff.getSalary();
        }
        System.out.println("部门工资为:"+(manageSalary+stuffSalary));
    }
}