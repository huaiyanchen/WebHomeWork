package com.homeWork.dao;


import com.homeWork.bean.EmpInfo;

import java.util.List;

public interface EmpInfoDao {

    /**
     *  @author: chy
     *  @Date: 2021/4/20 19:59
     *  @Description: 获取员工的最大编号 用于生成account
     */
    Integer getMaxId();

    /**
     *  @author: chy
     *  @Date: 2021/4/20 20:16
     *  @Description: 员工add
     *  todo
     */
    boolean addEmp(EmpInfo empInfo);

    /**
     *  @author: chy
     *  @Date: 2021/4/20 20:23
     *  @Description: 获取所有的员工
     */
    List<EmpInfo> getAllEmp();


    /**
     *  @author: chy
     *  @Date: 2021/4/20 21:25
     *  @Description: 修改员工信息
     */
    boolean updateEmp(EmpInfo empInfo);

    /**
     * 员工 注册
     * @param empInfo
     * @return
     *  事务回滚机制
     */
    boolean regEmp(EmpInfo empInfo);

}