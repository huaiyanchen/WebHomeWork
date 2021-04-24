package com.chy.classWork.test;

import com.chy.classWork.PE;
import com.chy.classWork.SE;
import com.chy.classWork.Salary;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-18:05
 * @Since:jdk1.8
 * @Description:
 */
public class CoderAndManagerTest {
    public static void main(String[] args) {
        PE coder = new PE(1, "yhc", "男", 15000, "hot");
        SE managerMent = new SE(1, "chy", "男", 35000, "2", 40);
        Salary salary = new Salary();
        salary.Salary(coder);
        salary.Salary(managerMent);

    }
}