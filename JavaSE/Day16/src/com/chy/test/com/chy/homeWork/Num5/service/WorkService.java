package com.chy.test.com.chy.homeWork.Num5.service;

import com.chy.test.com.chy.homeWork.Num5.bean.User;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-20:26
 * @Since:jdk1.8
 * @Description: 
 */
public interface WorkService {

    /**
     *  @author: chy
     *  @Date: 2021/4/13 15:14
     *  @Description: 添加用户信息
     */
    void addUser(List<User> userList);

    /**
     *  @author: chy
     *  @Date: 2021/4/13 15:14
     *  @Description: 根据id删除
     */
    void deleteById(Integer id,List<User> userList);

    /**
     *  @author: chy
     *  @Date: 2021/4/13 15:14
     *  @Description: 更新
     */
    void updateUser(List<User> userList);

    /**
     *  @author: chy
     *  @Date: 2021/4/13 15:14
     *  @Description: 查询
     */
    void findAllUser(List<User> userList);

    /**
     *  @author: chy
     *  @Date: 2021/4/13 15:14
     *  @Description: 根据id查询
     */
    User getUserById(Integer id);


}