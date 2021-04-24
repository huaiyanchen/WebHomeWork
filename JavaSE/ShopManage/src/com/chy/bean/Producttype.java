package com.chy.bean;

import lombok.Data;

import java.util.Date;

/**
 * producttype  商品类型
 *
 * @author
 */
@Data
public class Producttype  {
    //id
    private Integer id;

    //父级Id，0为没有父级Id
    private Integer parentid;

    //类型名称  饮用品 食品
    private String typename;

    //是否为父级Id，1为是  0为不是
    private Integer flagparent;

    private Date createtime;

    private Date updatetime;

}