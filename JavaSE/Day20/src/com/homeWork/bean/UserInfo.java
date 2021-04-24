package com.homeWork.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * user_info
 *
 * @author chy
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    //序号
    private Integer id;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //身份证号
    private String idCardNumber;

    //联系方式
    private String tel;

    //家庭住址
    private String address;

    //注册时间
    private Date loginTime;
}