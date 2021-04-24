package com.chy.bean.vo;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-20:19
 * @Since:jdk1.8
 * @Description:TODO
 */

@Data
public class ProductVO {

    //product id
    private Integer id;

    // product 剩余数量
    // 根据id修改剩余数量
    private Integer remainNum;
}