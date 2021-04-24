package com.homeWork.dao;

import com.homeWork.bean.Dept;

import java.util.List;

public interface DeptDao {
    /**
     *  @author: chy
     *  @Date: 2021/4/20 19:58
     *  @Description: 获取所有的部门及编号
     */
    List<Dept> getAllDept();
}