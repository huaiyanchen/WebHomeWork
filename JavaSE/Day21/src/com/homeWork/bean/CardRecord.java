package com.homeWork.bean;

import lombok.Data;

import java.util.Date;

/**
 * cardrecord
 *
 * @author
 */
@Data
public class CardRecord {
    //编号
    private Integer id;

    //员工编号
    private Integer empId;

    //打卡时间
    private Date cardTime;

    //是否正常打卡    1 正常  0 异常
    private Integer isNormal;

}