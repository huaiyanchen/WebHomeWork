package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Student
 * @author  chy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -3586069856360613903L;
    private Integer id;

    private String stuName;

    private String sex;

    private String birth;

    private String department;

    private String address;

}