package com.homeWork.dao.impl;

import com.homeWork.bean.Dept;
import com.homeWork.dao.DeptDao;
import com.homeWork.utils.DBUtils;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-19:42
 * @Since:jdk1.8
 * @Description:TODO
 */

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> getAllDept() {
        String sql = "select * from  dept";
        return DBUtils.executeQuery(sql, Dept.class);
    }

}