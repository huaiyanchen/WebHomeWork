package chy.homeWork.Num3.inter.Impl;

import chy.homeWork.Num3.bean.Student;
import chy.homeWork.Num3.bean.Subject;
import chy.homeWork.Num3.inter.ScoreSearch;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-19:58
 * @Since:jdk1.8
 * @Description:
 */
public class ScoreSearchImpl implements ScoreSearch {

    private Student[] students;

    public ScoreSearchImpl() {
        students = new Student[]{
                new Student("chy", new Subject[]
                        {new Subject("Java", "90"), new Subject("Web", "90")}),
                new Student("wxg", new Subject[]
                        {new Subject("Java", "98"), new Subject("Web", "99")}),
                new Student("dsm", new Subject[]
                        {new Subject("Java", "50"), new Subject("Web", "30")}),
                new Student("Uzi", new Subject[]
                        {new Subject("补刀", "1000"), new Subject("团战", "100000")}),
                new Student("55开", new Subject[]
                        {new Subject("口嗨", "10000"), new Subject("开挂", "100000")})
        };
    }

    @Override
    public Subject[] scoreSearchByName(Student student) {
        Subject[] subjects = new Subject[2];
        for (Student studentOrig : students) {
            if (studentOrig.getName().equals(student.getName())) {
                subjects = studentOrig.getSubjects();
            }
        }
        return subjects;
    }

    @Override
    public void calcScore(Student student) {
        //总成绩
        int sum = 0;
        //及格门数
        int count = 0;
        for (Student studentOrig : students) {
            if (studentOrig.getName().equals(student.getName())) {
                for (Subject subject : studentOrig.getSubjects()) {
                    sum += Integer.parseInt(subject.getScore());
                    if (Integer.parseInt(subject.getScore()) >= 60) {
                        count++;
                    }
                }
            }
        }
        System.out.println(student.getName() + "及格的门数为:" + count + "\t总成绩为:" + sum);
    }

    @Override
    public void showAll() {
        for (Student student : students) {
            System.out.println(student.getName() + "的学科和成绩有:");
            for (Subject subject : student.getSubjects()) {
                System.out.println(subject);
            }
            System.out.println();
        }
    }
}