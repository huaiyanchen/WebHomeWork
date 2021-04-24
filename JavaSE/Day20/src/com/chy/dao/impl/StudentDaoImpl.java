package com.chy.dao.impl;

import com.chy.bean.Student;
import com.chy.dao.StudentDao;
import com.chy.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-10:29
 * @Since:jdk1.8
 * @Description:
 */

public class StudentDaoImpl implements StudentDao {
    private Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    @Override
    public boolean add(Student student) {
        String sql = "insert into student values (?,?,?,?,?,?)";
        return DBUtils.executeUpdate(sql, student.getId(), student.getStuName(), student.getSex(),
                student.getBirth(), student.getDepartment(), student.getAddress());
    }

    @Override
    public boolean updateById(Student student) {
        String sql = "update student set stuName = ? , sex = ? , birth = ? ,department=?, address = ?  where id = ?";
        return DBUtils.executeUpdate(sql, student.getStuName(), student.getSex(),
                student.getBirth(), student.getDepartment(), student.getAddress(), student.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "delete from student where id = ?";
        return DBUtils.executeUpdate(sql,id);
    }

    @Override
    public List<Student> findAllStu() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from  student";
            try {
                resultSet = DBUtils.executeQuery(sql);
                while (resultSet.next()) {
                    Student student = new Student(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));
                    students.add(student);

                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }finally {
                DBUtils.closeCon(con, preparedStatement, resultSet);
            }

        return students;
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = null;
        String sql = "select * from  student where id = ?";
            try {
                resultSet = DBUtils.executeQuery(sql, id);
                while (resultSet.next()) {
                     student = new Student(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));

                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }finally {
                DBUtils.closeCon(con, preparedStatement, resultSet);
            }

        return student;
    }
}

