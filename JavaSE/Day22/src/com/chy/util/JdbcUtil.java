package com.chy.util;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-17:02
 * @Since:jdk1.8
 * @Description:
 */

public class JdbcUtil {


    public static Connection getCon() {
        String url = "jdbc:mysql://localhost:3306/shopmanage?" +
                "useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String pwd = "123456";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 增 删 改
     *
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object... params) {
        Connection con = getCon();
        int update = 0;
        QueryRunner queryRunner = new QueryRunner();
        try {
            update = queryRunner.update(con, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return update;
    }

    /**
     * 单个插入返回插入的id
     *
     * @param sql
     * @param params
     * @return
     */
    public static int executeInsetId(String sql, Object... params) {
        Connection con = getCon();
        int update = 0;
        QueryRunner queryRunner = new QueryRunner();
        try {
            update = queryRunner.insert(con, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return update;
    }

    /**
     * 查一个单个
     *
     * @param id
     */
    public static <T> T getById(String sql, Class clazz, Integer id) {
        Connection con = getCon();
        T query = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            query = queryRunner.query(con, sql, new BeanHandler<T>(clazz), id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return query;
    }

    /**
     * 返回所有的list
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> getAll(String sql, Class clazz, Object... params) {
        Connection con = getCon();
        List<T> query = new ArrayList<>();
        QueryRunner queryRunner = new QueryRunner();
        try {
            query = queryRunner.query(con, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return query;
    }
}