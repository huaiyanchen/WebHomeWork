package com.chy.dao;

import com.chy.bean.Vip;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-11:03
 * @Since:jdk1.8
 * @Description:TODO
 */

public interface VipDao {
    /**
     * 添加会员
     * @param vip
     * @return
     */
    int addVip(Vip vip);

    /**
     * 根据会员id 删除会员
     *
     * @param id
     * @return
     */
    int deleteVipById(Integer id);

    /**
     * 修改会员信息
     *
     * @param vip
     * @return
     */
    int updateVip(Vip vip);

    /**
     * 根据会员id查询会员信息
     *
     * @param id
     * @return
     */
    Vip selectVipById(Integer id);

    /**
     * 根据卡号查询会员信息
     *
     * @param cardNumber
     * @return
     */
    Vip selectByCardNumber(String cardNumber);

    /**
     * 展示所有的会员信息
     *
     * @return
     */
    List<Vip> selectAllVip();

    /**
     * 查询数据库中的最大的id用于生成cardNumber
     *
     * @return Vip
     */
    Vip selectMaxIdForCardNum();


}
