package com.chy.utils;

import com.chy.bean.StuInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String url = "jdbc:mysql://localhost:3306/test?" +
                "useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
        Connection connection = null;
        try {
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
            } finally {
                closeCon(con, preparedStatement);
            }
        }
        return i > 0;
    }

    //查询
    public static <T> List<T> executeQuery(String sql, Class<T> clazz, Object... paras) {
        List<T> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement preparedStatement;
        if ((con = getCon()) != null) {
            try {
                preparedStatement = con.prepareStatement(sql);
                System.out.println(preparedStatement.toString());
                if (paras != null && paras.length > 0) {
                    for (int j = 0; j < paras.length; j++) {
                        preparedStatement.setObject(j + 1, paras[j]);
                    }
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    T t = clazz.newInstance();
                    for (int i = 1; i <= columnCount; i++) {
                        //数据库列名-->set的方法名
                        String columnName = metaData.getColumnName(i);
                        //数据库列的属性
                        String columnTypeName = metaData.getColumnClassName(i);
                        //列内容 根据列名获取
                        Object object = resultSet.getObject(columnName);
                        //赋值
                        Method declaredMethod = clazz.getDeclaredMethod(ClassUtils.classStringCast(columnName), ClassUtils.classCast(columnTypeName));
                        declaredMethod.invoke(t, object);
                    }
                    list.add(t);
                    System.out.println("list = " + list);
                }


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String sql = "select * from  stu_info";
        List<StuInfo> users = executeQuery(sql, StuInfo.class);

    }
}