package com.chy.test;

import com.chy.bean.Computer;
import com.chy.bean.Student;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-17:55
 * @Since:jdk1.8
 * @Description: 
 */
public class StudentTest {
    public static void main(String[] args) {
        Computer computer = new Computer("1", "1", "1", "1", "1");
        Student student = new Student();
        student.setName("yhc");
        student.setNumber("123");
        student.setSex("男");
        student.setComputer(computer);
        student.study();
        System.out.println("student.isHaveComputer() = " + student.isHaveComputer(computer));

    }
}