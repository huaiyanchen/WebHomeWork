package com.chy.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * stu_info
 * @author 
 */
@Data
public class StuInfo implements Serializable {
    private Integer stuId;

    private String stuName;

    private String stuSex;

    private String stuTel;

    private Date stuBirth;

    private Integer classId;

    private static final long serialVersionUID = 1L;
}