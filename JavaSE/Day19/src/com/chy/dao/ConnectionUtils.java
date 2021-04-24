package com.chy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/17-15:07
 * @Since:jdk1.8
 * @Description: jdbc
 */


public class ConnectionUtils {
    public static Connection getCon() {
        Connection con = null;
        //数据准备
        String user = "root";
        String pwd = "123456";
        String url = "jdbc:mysql://localhost:3306/test?" +
                "useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        try {
            //加载驱动
           Class.forName(driver);
            //返回连接对象
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }


    public static void closeCon(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}