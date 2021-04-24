package com.chy.service;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:28
 * @Since:jdk1.8
 * @Description:TODO
 */

public interface ProductService {
    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 添加
     */
    void addProduct();

    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 删除
     */
    void deleteProduct();
    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 修改
     */
    void updateProduct();

    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:31
     *  @Description: 修改
     */
    void selectProduct();

    /**
     * 积分兑换商品
     */
    void jifen();

}