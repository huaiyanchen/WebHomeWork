package com.chy.util;

import java.sql.*;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-10:20
 * @Since:jdk1.8
 * @Description:
 */

public class DBUtils {
    //获取连接
    public static Connection getCon() {
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pwd = "123456";
        String url = "jdbc:mysql://localhost:3306/test2?" +
                "useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
        Connection connection = null;
        try {
//            版本不需要加载驱动这个步骤了
//           Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    //关闭连接
    public static void closeCon(Connection con, PreparedStatement preparedStatement) {
        try {
            if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //关闭连接
    public static void closeCon(Connection con, PreparedStatement preparedStatement, ResultSet set) {
        try {
            if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (set != null) {
                set.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //update  增加 删除  修改
    public static Boolean executeUpdate(String sql, Object... paras) {
        int i = 0;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        if ((con = getCon()) != null) {
            try {
                preparedStatement = con.prepareStatement(sql);
                if (paras != null && paras.length > 0) {
                    for (int j = 0; j < paras.length; j++) {
                        preparedStatement.setObject(j + 1, paras[j]);
                    }
                }
                i = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }finally {
                closeCon(con, preparedStatement);
            }
        }
        return i > 0;
    }

    public static ResultSet executeQuery(String sql, Object... paras) {
        ResultSet resultSet = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        if ((con = getCon()) != null) {
            try {
                 preparedStatement = con.prepareStatement(sql);
                if (paras != null && paras.length > 0) {
                    for (int j = 0; j < paras.length; j++) {
                        preparedStatement.setObject(j + 1, paras[j]);
                    }
                }
                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return resultSet;
    }

}