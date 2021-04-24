package com.chy.homeWork.num2.test;

import cn.hutool.crypto.SecureUtil;
import com.chy.homeWork.num2.bean.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-19:21
 * @Since:jdk1.8
 * @Description:
 */
public class StudentTest {
    static Scanner sc = new Scanner(System.in);


    //要求学号不允许重复
    private ArrayList<Student> addsStudent() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        System.out.println("请输入添加的学生数:");
        int addNumber = sc.nextInt();
        for (int i = 0; i < addNumber; i++) {
            Student student = new Student();
            System.out.println("请输入第" + (i + 1) + "个学生的姓名");
            student.setName(sc.next());
            System.out.println("请输入第" + (i + 1) + "个学生的年龄");
            student.setAge(sc.nextInt());
            System.out.println("请输入第" + (i + 1) + "个学生的性別");
            student.setSex(sc.next());

            String inputId = "";
            while (true) {
                System.out.println("请输入第" + (i + 1) + "个学生的学号");
                inputId = sc.next();
                boolean  b = true;
                for (Student student1 : studentArrayList) {
                    if (student1.getId().equals(inputId)) {
                        System.out.println("学号重复");
                        b = false;
                    }
                }
                if (b) {
                    break;
                }
            }
            student.setId(inputId);
            System.out.println("请输入第" + (i + 1) + "个学生的号码");
            student.setNumber(SecureUtil.md5(sc.next()));
            studentArrayList.add(student);
        }
        return studentArrayList;
    }

    private void show(ArrayList<Student> studentArrayList) {
        System.out.println(studentArrayList);
    }

    private ArrayList<Student> removeStudent(ArrayList<Student> studentArrayList) {
        for (Student student : studentArrayList) {
            if (student.getAge() < 18) {
                studentArrayList.remove(studentArrayList.indexOf(student));
            }
        }
        return studentArrayList;
    }

    private void countNumber(ArrayList<Student> studentArrayList) {
        int numberOfStudent = studentArrayList.size();
        int numOfBoy = 0;
        int numOfGirl = 0;
        for (Student student : studentArrayList) {
            if (student.getSex().equals("男")) {
                numOfBoy++;
            }
            if (student.getSex().equals("女")) {
                numOfGirl++;
            }
        }
        System.out.println("numberOfStudent = " + numberOfStudent);
        System.out.println("numOfBoy = " + numOfBoy);
        System.out.println("numOfGirl = " + numOfGirl);
    }

    public static void main(String[] args) {

        StudentTest studentTest = new StudentTest();
        ArrayList<Student> studentArrayList;
        studentArrayList = studentTest.addsStudent();
        studentTest.show(studentArrayList);
        studentArrayList = studentTest.removeStudent(studentArrayList);
        studentTest.countNumber(studentArrayList);
        System.out.println(studentArrayList);

    }
}