package com.chy.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/23-10:09
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
public class OrderDetailInfo {
    //详细订单编号
    private Integer id;
    // info订单编号
    private Integer orderid;
    //商品Id
    private Integer productid;
    //该商品的数量
    private Integer num;
    //付的金额
    private Double money;
    //会员账号
    private Integer vipid;
    //订购日期
    private Date orderdate;
    //付款方式
    private Integer paytype;
}