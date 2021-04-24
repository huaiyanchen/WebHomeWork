package com.chy.bean;

import lombok.Data;

import java.util.Date;

/**
 * vip 会员
 * @author
 */
@Data
public class Vip {
    //会员编号
    private Integer id;

    //卡号
    private String cardnumber;

    //姓名
    private String vipname;

    //手机号
    private String iphone;

    //积分
    private Integer jifen;

    // 余额
    private Double money;

    //注册时间
    private Date createtime;

    //修改日期
    private Date updatetime;

}