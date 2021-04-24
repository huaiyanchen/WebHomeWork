package com.homeWork.dao.impl;


import cn.hutool.core.util.StrUtil;
import com.homeWork.bean.UserInfo;
import com.homeWork.dao.UserDao;
import com.homeWork.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-17:41
 * @Since:jdk1.8
 * @Description:
 */

public class UserDaoImpl implements UserDao {

    @Override
    public boolean add(UserInfo user) {
        String sql = "insert into user_info values (null,?,?,?,?,?,?)";
        return DBUtils.executeUpdate(sql, user.getName(), user.getAge(), user.getIdCardNumber(),
                user.getTel(), user.getAddress(), user.getLoginTime());

    }

    @Override
    public List<String> getAllIdNumber() {
        String sql = "select idCard_number from user_info";
        List<String> stringList = new ArrayList<>();
        ResultSet resultSet = DBUtils.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String idNumber = resultSet.getString(1);
                stringList.add(idNumber);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stringList;

    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "delete from user_info where id = ?";
        return DBUtils.executeUpdate(sql, id);
    }

    @Override
    public List<UserInfo> findAllUsr() {
        String sql = "select * from  user_info";
        List<UserInfo> userInfos = new ArrayList<>();
        ResultSet resultSet = DBUtils.executeQuery(sql);
        try {
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("age"),
                        resultSet.getString("idCard_number"),
                        resultSet.getString("tel"),
                        resultSet.getString("address"),
                        resultSet.getDate("login_time"));
                userInfos.add(userInfo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findByTelOrIdNum(String... args) {
        String sql2 = "select * from user_info where idCard_number like ? and tel like ?";
        List<UserInfo> userInfos = new ArrayList<>();
        ResultSet resultSet = DBUtils.executeQuery(sql2, "%"+args[0]+"%", "%"+args[1]+"%");

        try {
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("age"),
                        resultSet.getString("idCard_number"),
                        resultSet.getString("tel"),
                        resultSet.getString("address"),
                        resultSet.getDate("login_time"));
                userInfos.add(userInfo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userInfos;

    }

    @Override
    public List<UserInfo> findByTel(String tel) {
        String sql1 = "select * from user_info where tel like ?";
        List<UserInfo> userInfos = new ArrayList<>();
        ResultSet resultSet = DBUtils.executeQuery(sql1, "%"+tel+"%");
        try {
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("age"),
                        resultSet.getString("idCard_number"),
                        resultSet.getString("tel"),
                        resultSet.getString("address"),
                        resultSet.getDate("login_time"));
                userInfos.add(userInfo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findByIdNum(String idNum) {
        String sql1 = "select * from user_info where idCard_number like ?";
        List<UserInfo> userInfos = new ArrayList<>();
        ResultSet resultSet = DBUtils.executeQuery(sql1, "%"+idNum+"%");
        try {
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("age"),
                        resultSet.getString("idCard_number"),
                        resultSet.getString("tel"),
                        resultSet.getString("address"),
                        resultSet.getDate("login_time"));
                userInfos.add(userInfo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userInfos;
    }

    @Override
    public UserInfo getById(Integer id) {
        String sql = "select * from user_info where id = ? ";
        ResultSet resultSet = DBUtils.executeQuery(sql, id);
        UserInfo userInfo = null;
        try {
            if (resultSet.next()) {
                userInfo = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("age"),
                        resultSet.getString("idCard_number"),
                        resultSet.getString("tel"),
                        resultSet.getString("address"),
                        resultSet.getDate("login_time"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return userInfo;
    }

    @Override
    public boolean updateById(UserInfo userInfo, Integer id) {
        String sql = "update user_info set name = ?,age = ? ,idCard_number = ?,tel =?, address = ? where id =?";
        return DBUtils.executeUpdate(sql, userInfo.getName(), userInfo.getAge(), userInfo.getIdCardNumber(), userInfo.getTel(), userInfo.getAddress(), userInfo.getId());
    }

    @Override
    public List<UserInfo> queryByIdAndTel(String idNum, String tel) {
        List<UserInfo> userInfoList = new ArrayList<>();
        String sql = "select * from  user_info where 1 = 1 ";
        if (!StrUtil.hasEmpty(idNum)) {
            sql += "and idCard_number like '%" + idNum + "%'";
        }
        if (!StrUtil.hasEmpty(tel)) {
            sql += "and tel like '%" + tel + "%'";
        }
        Connection con = DBUtils.getCon();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("age"),
                        resultSet.getString("idCard_number"),
                        resultSet.getString("tel"),
                        resultSet.getString("address"),
                        resultSet.getDate("login_time"));
                userInfoList.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfoList;
    }

}