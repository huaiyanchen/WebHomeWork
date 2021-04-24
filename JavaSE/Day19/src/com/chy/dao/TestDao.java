package com.chy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/17-15:49
 * @Since:jdk1.8
 * @Description: test
 */
public class TestDao {
    /**
     * @author: chy
     * @Date: 2021/4/17 16:59
     * @Description: add
     */
    public void addTest() {
        String sql = "insert into test values (2,'hyc') ";
        //获取连接
        Connection con = ConnectionUtils.getCon();

        Statement statement = null;
        if (con != null) {
            try {
                statement = con.createStatement();
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("插入成功");
                } else {
                    System.out.println("插入失败");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionUtils.closeCon(con, statement, null);
            }
        }

    }

    /**
     * @author: chy
     * @Date: 2021/4/17 16:59
     * @Description: delete
     */
    public void deleteTest() {
        String sql = "delete from test where id = 1";
        Connection con = ConnectionUtils.getCon();
        Statement statement = null;
        if (con != null) {
            try {
                statement = con.createStatement();
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionUtils.closeCon(con, statement, null);
            }
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/17 16:59
     * @Description: update
     */
    public void updateTest() {
        String sql = "update test set  name = 'teUpdate' where id = 1 ";
        Connection con = ConnectionUtils.getCon();

        Statement statement = null;
        if (con != null) {
            try {
                statement = con.createStatement();
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("更新成功");
                } else {
                    System.out.println("更新失败");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionUtils.closeCon(con, statement, null);
            }
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/17 16:59
     * @Description: select
     */
    public void selectTest() {
        String sql = "select * from test  order by id ";
        Connection con = ConnectionUtils.getCon();
        Statement statement = null;
        ResultSet resultSet = null;
        if (con != null) {
            try {
                statement = con.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ConnectionUtils.closeCon(con, statement, resultSet);
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/17 16:59
     * @Description: selectById
     */
    public void selectByIdTest(Integer id) {
        String sql = "select * from test where id  = " + id + " order by id ";
        Connection con = ConnectionUtils.getCon();
        Statement statement = null;
        ResultSet resultSet = null;
        if (con != null) {
            try {
                statement = con.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ConnectionUtils.closeCon(con, statement, resultSet);
        }
    }

    /*
     main
     */
    public static void main(String[] args) {
        TestDao testDao = new TestDao();
//        testDao.addTest();
        testDao.selectTest();
    }

}