package com.chy.homeWork.Num1.test;

import com.chy.homeWork.Num1.bean.JavaTeacher;
import com.chy.homeWork.Num1.bean.Teacher;
import com.chy.homeWork.Num1.bean.WebTeacher;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-17:55
 * @Since:jdk1.8
 * @Description: 
 */
public class TeacherTest {
    public static void main(String[] args) {
        Teacher javaTeacher = new JavaTeacher();
        javaTeacher.setNumber(11111);
        javaTeacher.setName("王");
        javaTeacher.setClassName(javaTeacher.getClassName());
        javaTeacher.selfIntroduction();
        javaTeacher.teacherRating();


        Teacher webTeacher = new WebTeacher();
        webTeacher.setNumber(11112);
        webTeacher.setName("张");
        webTeacher.setClassName(javaTeacher.getClassName());
        webTeacher.selfIntroduction();
        webTeacher.teacherRating();
    }
}