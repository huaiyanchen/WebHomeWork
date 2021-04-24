package com.homeWork.bean;

import lombok.Data;

import java.util.Date;

/**
 * cardrecord
 *
 * @author
 */
@Data
public class EmpInfo {
    //員工编号
    private Integer id;

    //员工账号
    private String account;

    //密码
    private String pwd;

    //部门编号
    private Integer deptId;

    //员工姓名
    private String name;

    //员工性别
    private String sex;

    //入职时间
    private Date entryTime;


}