package com.chy.bean.vo;

import com.chy.bean.Orderdetails;
import com.chy.bean.Orderinfo;
import com.chy.bean.Vip;
import lombok.Data;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/`22-17:34
 * @Since:jdk1.8
 * @Description:
 */

@Data
public class BuyVO {
    // 详细订单列表
    private List<Orderdetails> orderDetailsList;
    //一单临时订单
    private Orderinfo orderinfo;
    //购买的商品列表
    private List<ProductVO> productVOS;
    //购买后的会员信息
    private Vip vip;
}