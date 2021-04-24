package com.chy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/17-17:21
 * @Since:jdk1.8
 * @Description: delete
 */

public class TestPrepareStatementDao {
    /**
     *  @author: chy
     *  @Date: 2021/4/17 17:40
     *  @Description: add
     */
    public int add(Integer id, String name) {
        int i = 0;
        String sql = "insert into test values(?,?)";
        Connection con = ConnectionUtils.getCon();
        PreparedStatement preparedStatement = null;
        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                i = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionUtils.closeCon(con, preparedStatement, null);
            }
        }
        return i;
    }

    /**
     *  @author: chy
     *  @Date: 2021/4/17 17:41
     *  @Description: deleteById
     */
    public int deleteById(Integer id) {
        int i = 0;
        String sql = "delete from test where id = ?";
        Connection con = ConnectionUtils.getCon();
        PreparedStatement preparedStatement = null;
        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                i = preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                ConnectionUtils.closeCon(con, preparedStatement, null);
            }
        }
        return i;
    }

    /*
      main
     */
    public static void main(String[] args) {
        TestPrepareStatementDao testPrepareStatementDao = new TestPrepareStatementDao();
        int ydw = testPrepareStatementDao.deleteById(5);
        if (ydw > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}