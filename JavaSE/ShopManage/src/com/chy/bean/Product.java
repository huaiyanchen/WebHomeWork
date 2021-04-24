package com.chy.bean;

import lombok.Data;

/**
 * product  商品
 *
 * @author
 */
@Data
public class Product  {
    //id
    private Integer id;

    //商品名
    private String pname;

    //单价
    private Double price;

    //库存量
    private Integer num;

    //折扣
    private Integer discount;

    //类型
    private Integer typeid;

    //1为上架，2为下架，3为删除
    private Integer state;


}