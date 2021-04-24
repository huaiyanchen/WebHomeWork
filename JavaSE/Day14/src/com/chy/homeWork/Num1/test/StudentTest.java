package com.chy.homeWork.Num1.test;

import com.chy.homeWork.Num1.bean.Student;

import java.util.*;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-20:24
 * @Since:jdk1.8
 * @Description: 
 */
public class StudentTest {

    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student((new Random().nextInt(40) + 1), new Random().nextInt(101));
            set.add(student);
        }

        Student studentMax = set.stream().max(Comparator.comparing(Student::getScore)).get();
        Student studentMin = set.stream().min(Comparator.comparing(Student::getScore)).get();
        System.out.println("studentMax = " + studentMax);
        System.out.println("studentMin = " + studentMin);
    }
}