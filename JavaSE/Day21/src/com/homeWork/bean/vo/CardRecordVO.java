package com.homeWork.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-21:43
 * @Since:jdk1.8
 * @Description:TODO
 */

@Data
public class CardRecordVO {
    //打卡记录
    private Integer id;
    //姓名
    private String name;
    //性别
    private String sex;
    //入职时间
    private Date entryTime;
    //打卡时间
    private Date cardTime;
    //是否正常打卡  1 正常 0 异常
    private Integer isNormal;

}