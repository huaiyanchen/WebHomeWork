package chy.homeWork.Num3.test;

import chy.homeWork.Num3.bean.Student;
import chy.homeWork.Num3.inter.Impl.ScoreSearchImpl;
import chy.homeWork.Num3.inter.ScoreSearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-20:32
 * @Since:jdk1.8
 * @Description: 
 */
public class StudentTest {
    public void menu() {
        ScoreSearch scoreSearch = new ScoreSearchImpl();
        Student student = new Student();
        while (true) {
            System.out.println("请选择");
            System.out.println("1.查询所有学生");
            System.out.println("2.根据某个学生的名称，计算及格的成绩有几门？并且计算出该学生的总分数");
            System.out.println("3.根据某个学生的名称，查找对应的成绩有");
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1:
                    scoreSearch.showAll();
                    break;
                case 2:
                    System.out.println("输入学生姓名:");
                    student.setName(new Scanner(System.in).next());
                    scoreSearch.calcScore(student);
                    break;
                case 3:
                    System.out.println("输入学生姓名:");
                    student.setName(new Scanner(System.in).next());
                    System.out.println("scoreSearch.scoreSearchByName(student) = " + Arrays.toString(scoreSearch.scoreSearchByName(student)));
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest();
        studentTest.menu();
    }
}