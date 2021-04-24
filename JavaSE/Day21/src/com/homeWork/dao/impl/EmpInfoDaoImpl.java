package com.homeWork.dao.impl;

import com.homeWork.bean.EmpInfo;
import com.homeWork.dao.EmpInfoDao;
import com.homeWork.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-19:48
 * @Since:jdk1.8
 * @Description:TODO
 */

public class EmpInfoDaoImpl implements EmpInfoDao {
    @Override
    public Integer getMaxId() {
        String sql = "select * from empinfo order by id desc limit 1";
        List<EmpInfo> empInfos = DBUtils.executeQuery(sql, EmpInfo.class);
        Integer id = empInfos.get(0).getId();
        return id + 1;
    }

    @Override
    public boolean addEmp(EmpInfo empInfo) {
        String sql = "insert into empinfo values(null,?,?,?,?,?,?)";
        return DBUtils.executeUpdate(sql, empInfo.getAccount(),
                empInfo.getPwd(), empInfo.getDeptId(), empInfo.getName(), empInfo.getSex(), empInfo.getEntryTime());
    }

    @Override
    public List<EmpInfo> getAllEmp() {
        String sql = "select * from empinfo";
        return DBUtils.executeQuery(sql, EmpInfo.class);
    }

    @Override
    public boolean updateEmp(EmpInfo empInfo) {
        String sql = "update empinfo set pwd =? ,deptId = ? ,name = ?, sex = ? where id = ? ";
            return DBUtils.executeUpdate(sql,
                empInfo.getPwd(), empInfo.getDeptId(), empInfo.getName(), empInfo.getSex(), empInfo.getId());
    }

    @Override
    public boolean regEmp(EmpInfo empInfo) {
        int i = 0;
        //获取数据库的连接
        Connection connection = DBUtils.getCon();
        //新增sql
        String sql1 = "insert into empinfo values(null,null,?,?,?,?,?)";
        //执行对象
        PreparedStatement ptm = null;
        if (connection != null) {
            try {
                //事务的提交方式为手动
                connection.setAutoCommit(false);

                ptm = connection.prepareStatement(sql1);
                //解决参数
                ptm.setString(1, empInfo.getPwd());
                ptm.setInt(2, empInfo.getDeptId());
                ptm.setString(3, empInfo.getName());
                ptm.setString(4, empInfo.getSex());
                ptm.setObject(5, empInfo.getEntryTime());

                //执行第一个sql语句
                i = ptm.executeUpdate();
                if (i > 0) {
                    //准备sql2
                    String sql2 = "select LAST_INSERT_ID()";
                    ptm = connection.prepareStatement(sql2);
                    ResultSet rs = ptm.executeQuery();
                    int id = -1;
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                    //id不能-1
                    if (id != -1) {
                        String sql3 = "update empinfo set account = CONCAT(?,?) where id = ?";
                        ptm = connection.prepareStatement(sql3);
                        ptm.setString(1, empInfo.getAccount());
                        ptm.setInt(2, id);
                        ptm.setInt(3, id);
                        i = ptm.executeUpdate();

                        if (i > 0) {
                            //提交事务
                            connection.commit();
                        } else {
                            i = 0;
                            //事务回滚
                            connection.rollback();
                        }
                    } else {
                        i = 0;
                        //事务回滚
                        connection.rollback();
                    }
                } else {
                    i = 0;
                    //事务回滚
                    connection.rollback();
                }
            } catch (SQLException e) {
//                e.printStackTrace();
                try {
                    i = 0;
                    //事务回滚
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                try {
                    //将事务的提交方式改为手动
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
//                    e.printStackTrace();
                }
                DBUtils.closeCon(connection, ptm);
            }
        }
        return i > 0;
    }
}