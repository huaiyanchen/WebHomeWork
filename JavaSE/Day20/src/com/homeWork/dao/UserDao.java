package com.homeWork.dao;

import com.homeWork.bean.UserInfo;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-10:28
 * @Since:jdk1.8
 * @Description:
 */
public interface UserDao {
    /**
     * @author: chy
     * @Date: 2021/4/19 10:46
     * @Description: 添加用户信息
     */
    boolean add(UserInfo user);

    /**
     * @author: chy
     * @Date: 2021/4/19 19:01
     * @Description: 查询所有的idCardNumber 用于添加时的查重
     */
    List<String> getAllIdNumber();

    /**
     * @author: chy
     * @Date: 2021/4/19 10:46
     * @Description: 删除员工信息
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有信息
     *
     * @return
     */
    List<UserInfo> findAllUsr();


    /**
     * 按照身份证号和联系方式模糊查询
     * @param args
     * @return
     */
    List<UserInfo> findByTelOrIdNum(String... args);

    /**
     * 按照身份证号和联系方式模糊查询
     * @param tel
     * @return
     */
    List<UserInfo> findByTel(String tel);

    /**
     * 按照身份证号和联系方式模糊查询
     * @param idNum
     * @return
     */
    List<UserInfo> findByIdNum(String idNum);


    /**
     * @author: chy
     * @Date: 2021/4/19 19:55
     * @Description: 根据Id查询
     */
    UserInfo getById(Integer id);

    /**
     * @author: chy
     * @Date: 2021/4/19 11:52
     * @Description: update 直接操作对象
     */
    boolean updateById(UserInfo userInfo, Integer id);


    /**
     *  @author: chy
     *  @Date: 2021/4/20 11:23
     *  @Description: 根据身份证号和电话号码 模糊查询
     *  todo  就是普通的字符串拼接到sql中 然后就是注意
     */
    List<UserInfo> queryByIdAndTel(String idNum, String tel);
}