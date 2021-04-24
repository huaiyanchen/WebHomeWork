package com.chy.test;

import com.chy.bean.Coder;
import com.chy.bean.ManagerMent;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.security.CodeSource;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-18:05
 * @Since:jdk1.8
 * @Description: 
 */
public class CoderAndManagerTest {
    public static void main(String[] args) {
        Coder coder = new Coder(1, "yhc", "男", 15000, "hot");
        ManagerMent managerMent = new ManagerMent(1, "chy", "男", 35000, "2", "40");
        System.out.println("coder.salary() = " + coder.salary());
        System.out.println("managerMent.salary() = " + managerMent.salary());
        coder.show();
        managerMent.show();

    }
}