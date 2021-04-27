package com.chy.dao;

import com.chy.bean.Orderdetails;
import com.chy.bean.Orderinfo;
import com.chy.bean.vo.BuyVO;
import com.chy.bean.vo.OrderDetailInfo;
import com.chy.bean.vo.RankProVO;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-20:30
 * @Since:jdk1.8
 * @Description:
 */

public interface OrderDao {

    /**
     * 购买付款后的订单生成,
     * @param buyVO
     * @return
     */
    boolean buy4TableAlert(BuyVO buyVO);


    /**
     * 根据商品编号查询 Orderdetails
     * @param proId
     * @return
     */
    List<Orderdetails> selectOrderDetailByPId(Integer proId);

    /**
     * 根据商品编号查询 详细的OrderDetailInfo订单表
     * @param proId
     * @return
     */
    List<OrderDetailInfo> select2TableByProductId(Integer proId);

    /**
     * 根据vip编号编号查询 详细的OrderDetailInfo订单表
     * @param
     * @return
     */
    List<OrderDetailInfo> select2TableByVipId(Integer VipId);

    /**
     * 根据vip编号商品编号查询 详细的OrderDetailInfo订单表
     * @param proId
     * @param VipId
     * @return
     */
    List<OrderDetailInfo> select2TableByPVId(Integer proId, Integer VipId);


    /**
     * 为了排行榜 数量
     * @return
     */
    List<RankProVO> findOrderForRankProductid(Integer month ,Integer typeId);

    /**
     * 根据会员id查询订单表
     * @param id
     * @return
     */
    List<Orderinfo> selectOrderInfoByVId(Integer id);

}