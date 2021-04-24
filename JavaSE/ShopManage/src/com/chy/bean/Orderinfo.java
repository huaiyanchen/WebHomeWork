package com.chy.bean;

import lombok.Data;

import java.util.Date;

/**
 * orderinfo
 *   简要时间表
 *
 * @author
 */
@Data
public class Orderinfo  {
    //id
    private Integer id;

    //会员编号
    private Integer vipid;

    // 暂时 没有用上的列 cloume
    private Double price;

    //支付日期
    private Date orderdate;

    //订单支付方式，1：现金，2：卡内余额
    private Integer paytype;

    /**
     * 支付金额
     */
    private Double money;

}