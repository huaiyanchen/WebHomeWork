package com.chy.service;

import java.util.Map;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-16:10
 * @Since:jdk1.8
 * @Description:TODO
 */

public interface OrderService {
    /**
     * 添加购物车商品
     *
     * @param buyCar
     */
    void addProduct(Map<Integer, Integer> buyCar);

    /**
     * 删除购物车商品
     *
     * @param buyCar
     */
    void deleteProduct(Map<Integer, Integer> buyCar);

    /**
     * 修改购物车商品
     *
     * @param buyCar
     */
    void updateProduct(Map<Integer, Integer> buyCar);

    /**
     * 展示购物车商品
     *
     * @param buyCar
     */
    void showProduct(Map<Integer, Integer> buyCar);

    /**
     * 购物车添加成功后的购买操作
     *
     * @param buyCar
     */
    void pay(Map<Integer, Integer> buyCar);

    /**
     * 订单查询 商品Id
     */
    void orderManageByPid();

    /**
     * 订单查询 会员id
     */
    void orderManageByVid();

    /**
     * 订单查询 会员Id和商品Id
     */
    void orderManageByPidVid();

    /**
     * @author: chy
     * @Date: 2021/4/22 22:26
     * @Description: 订单排行
     */
    void rankByPM();


}