package chy.homeWork.Num2.test;

import chy.homeWork.Num2.bean.Person;
import chy.homeWork.Num2.bean.Student;
import chy.homeWork.Num2.bean.Teacher;
import chy.homeWork.Num2.inter.Impl.LoginImpl;
import chy.homeWork.Num2.inter.Login;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-19:40
 * @Since:jdk1.8
 * @Description:
 */
public class LoginTest {
    public static void main(String[] args) {
        Person student = new Student("chy", "123456", "123456");
        Person teacher = new Teacher("hyc", "654321", "654321");
        Login login = new LoginImpl();
        login.login(student);
        login.login(teacher);
    }
}