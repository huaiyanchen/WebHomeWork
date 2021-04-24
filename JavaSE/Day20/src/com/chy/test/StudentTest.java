package com.chy.test;

import com.chy.bean.Score;
import com.chy.bean.Student;
import com.chy.dao.ScoreDao;
import com.chy.dao.StudentDao;
import com.chy.dao.impl.ScoreDaoImpl;
import com.chy.dao.impl.StudentDaoImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-10:40
 * @Since:jdk1.8
 * @Description:
 */
public class StudentTest {
    private StudentDao studentDao = new StudentDaoImpl();
    private ScoreDao scoreDao = new ScoreDaoImpl();
    private Student student;
    private Scanner scanner = new Scanner(System.in);

    //菜单
    public void menu() {
        System.out.println("欢迎使用学生管理系统");
        boolean b = true;
        while (b) {
            System.out.println("请输入选择:");
            System.out.println("1,添加 2,查看所有 3,删除 4,根据学生编号查看, 5,查询所有人成绩 \n 6.根据学号插入成绩 7.根据学号修改学生信息");
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    findStudentAll();
                    break;
                case "3":
                    deleteStudentById();
                    break;
                case "4":
                    getStudentById();
                    break;
                case "5":
                    findScoreAll();
                    break;
                case "6":
                    addScore();
                    break;
                case "7":
                    updateStudentById();
                    break;
                case "9":
                    b = false;
                    System.out.println("正在退出ing......");
                    break;
                default:
                    System.out.println("输入错误,重新选择 ");
                    break;
            }
        }

    }

    //addStudent
    private void addStudent() {
        student = new Student();
        System.out.println("请输入正确的学生信息:");
        System.out.println("请输入正确的学生编号:");
        student.setId(scanner.nextInt());
        System.out.println("请输入正确的学生姓名:");
        student.setStuName(scanner.next());
        System.out.println("请输入正确的学生性别:");
        student.setSex(scanner.next());
        System.out.println("请输入正确的学生出生年:");
        student.setBirth(scanner.next());
        System.out.println("请输入正确的学生院系:");
        student.setDepartment(scanner.next());
        System.out.println("请输入正确的学生地址 :");
        student.setAddress(scanner.next());

        boolean add = studentDao.add(student);
        if (add) {
            System.out.println("添加成功");
        }
    }

    //deleteStudentById
    private void deleteStudentById() {
        System.out.println("请输入删除的Id:");
        int id = scanner.nextInt();
        boolean del = studentDao.deleteById(id);
        if (del) {
            System.out.println("删除成功");
        }
    }

    //findStudentAll
    private void findStudentAll() {
        List<Student> allStu = studentDao.findAllStu();
        System.out.println("id \t 姓名 \t  性别 \t 院系 \t 出生年 \t  家庭住址   ");
        if (allStu != null && allStu.size() > 0) {
            allStu.forEach(student1 -> System.out.println(student1.getId() + "\t" + student1.getStuName() + "\t" + student1.getSex() +
                    "\t" + student1.getDepartment() + "\t" + student1.getBirth() + "\t" + student1.getAddress()));

        } else {
            System.out.println("查无此生");
        }
    }

    //getStudentById
    private void getStudentById() {
        System.out.println("请输入查询学生的id");
        Student student1 = studentDao.getStudentById(scanner.nextInt());
        if (student1 != null) {
            System.out.println("id \t 姓名 \t  性别 \t 院系 \t 出生年 \t  家庭住址   ");
            System.out.println(student1.getId() + "\t" + student1.getStuName() + "\t" + student1.getSex() +
                    "\t" + student1.getDepartment() + "\t" + student1.getBirth() + "\t" + student1.getAddress());
        } else {
            System.out.println("查无此生");
        }

    }

    //updateById
    private void updateStudentById() {
        Student student1 = new Student();
        System.out.println("请输入要修改的学生id");
        int updateId = scanner.nextInt();
        Student studentByUpdateId = studentDao.getStudentById(updateId);

        if (studentByUpdateId != null) {
            System.out.println("id \t 姓名 \t  性别 \t 院系 \t 出生年 \t  家庭住址   ");
            System.out.println(studentByUpdateId.getId() + "\t" + studentByUpdateId.getStuName() + "\t" + studentByUpdateId.getSex() +
                    "\t" + studentByUpdateId.getDepartment() + "\t" + studentByUpdateId.getBirth() + "\t" + studentByUpdateId.getAddress());
        } else {
            System.out.println("查无此生");
        }
        System.out.println("请依次输入修改后的信息 ");
        System.out.println("请输入正确的学生姓名:");
        student1.setStuName(scanner.next());
        System.out.println("请输入正确的学生性别:");
        student1.setSex(scanner.next());
        System.out.println("请输入正确的学生出生年:");
        student1.setBirth(scanner.next());
        System.out.println("请输入正确的学生院系:");
        student1.setDepartment(scanner.next());
        System.out.println("请输入正确的学生地址 :");
        student1.setAddress(scanner.next());
        student1.setId(updateId);

        studentDao.updateById(student1);
    }

    //添加成绩
    private void addScore() {
        Score score = new Score();
        Student student1 = new Student();
        System.out.println("请输入添加的学生学号");
        student1.setId(scanner.nextInt());
        score.setStudent(student1);

        System.out.println("请输入科目");
        score.setCName(scanner.next());
        System.out.println("请输入成绩");
        score.setGrade(scanner.nextInt());
        boolean add = scoreDao.add(score);
        if (add) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败哦");
        }


    }

    //查询所有成绩
    private void findScoreAll() {
        List<Score> allStu = scoreDao.findAllStu();
        if (allStu != null && allStu.size() > 0) {
            System.out.println("姓名 \t 成绩编号 \t 学号 \t  科目 \t 成绩");
            allStu.forEach(score -> System.out.println(score.getStudent().getStuName() + "\t" +
                    score.getId() + "\t" +
                    score.getStudent().getId() + "\t" +
                    score.getCName() + "\t" +
                    score.getGrade()));
        } else {
            System.out.println("no  grade!");
        }


    }

}
