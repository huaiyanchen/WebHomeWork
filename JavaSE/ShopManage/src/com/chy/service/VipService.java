package com.chy.service;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:28
 * @Since:jdk1.8
 * @Description:TODO
 */

public interface VipService {
    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 添加
     */
    void addVip();

    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 删除
     */
    void deleteVip();
    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 修改
     */
    void updateVip();

    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:31
     *  @Description: 修改
     */
    void selectVip();

    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:36
     *  @Description: 修改会员信息
     */
    void updateVipMoney();


}