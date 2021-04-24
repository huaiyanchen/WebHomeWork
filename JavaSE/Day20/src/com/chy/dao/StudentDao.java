package com.chy.dao;

import com.chy.bean.Student;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-10:28
 * @Since:jdk1.8
 * @Description:
 */
public interface StudentDao {
    /**
     *  @author: chy
     *  @Date: 2021/4/19 10:46
     *  @Description: 添加学生信息
     */
    boolean add(Student student);

    /**
     *  @author: chy
     *  @Date: 2021/4/19 10:46
     *  @Description: 删除学生信息
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有信息
     * @return
     */
    List<Student> findAllStu();

    /**
     * @author: chy
     * @Date: 2021/4/19 11:24
     * @Description: getStudentById
     */
    Student getStudentById(Integer id);

    /**
     *  @author: chy
     *  @Date: 2021/4/19 11:52
     *  @Description:  update 直接操作对象
     */
    boolean updateById(Student student);
}