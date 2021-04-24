package com.chy.bean;

import lombok.Data;

/**
 * orderdetails
 *
 * @author
 */
@Data
public class Orderdetails {
    //id
    private Integer id;

    //订单编号 Orderinfo 的Id
    private Integer orderid;

    //商品编号
    private Integer productid;

    //商品数量
    private Integer num;

    //价格
    private Double money;

}