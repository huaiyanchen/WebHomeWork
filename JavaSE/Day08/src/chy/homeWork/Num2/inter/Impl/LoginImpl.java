package chy.homeWork.Num2.inter.Impl;

import chy.homeWork.Num2.bean.Person;
import chy.homeWork.Num2.bean.Student;
import chy.homeWork.Num2.bean.Teacher;
import chy.homeWork.Num2.inter.Login;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-19:04
 * @Since:jdk1.8
 * @Description:
 */
public class LoginImpl implements Login {
    private Student student;
    private Teacher teacher;

    public LoginImpl() {
        student = new Student("chy", "123456", "123456");
        teacher = new Teacher("hyc", "654321", "654321");
    }

    @Override
    public boolean login(Person person) {
        if (person instanceof Student) {
            Student student1 = (Student) person;
            if (student1.getId().equals(student.getId()) && student1.getPwd().equals(student.getPwd())) {
                System.out.println(student1.getName()+"登陆成功");
                return true;
            } else {
                System.out.println("用户名或密码错误");
            }
        }
        if (person instanceof Teacher) {
            Teacher teacher1 = (Teacher) person;
            if (teacher1.getId().equals(teacher.getId()) && teacher1.getPwd().equals(teacher.getPwd())) {
                System.out.println(teacher1.getName()+"登陆成功");
                return true;
            } else {
                System.out.println("用户名或密码错误");
            }
        }
        return false;
    }
}