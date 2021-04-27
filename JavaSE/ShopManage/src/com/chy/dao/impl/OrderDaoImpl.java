package com.chy.dao.impl;

import com.chy.bean.Orderdetails;
import com.chy.bean.Orderinfo;
import com.chy.bean.Vip;
import com.chy.bean.vo.BuyVO;
import com.chy.bean.vo.OrderDetailInfo;
import com.chy.bean.vo.ProductVO;
import com.chy.bean.vo.RankProVO;
import com.chy.dao.OrderDao;
import com.chy.utils.JdbcUtil;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-19:47
 * @Since:jdk1.8
 * @Description:TODO
 */

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean buy4TableAlert(BuyVO buyVO) {
        //插入的数据准备
        Orderinfo orderinfo = buyVO.getOrderinfo();
        List<Orderdetails> orderDetailsList = buyVO.getOrderDetailsList();
        Vip vip = buyVO.getVip();
        List<ProductVO> productVOS = buyVO.getProductVOS();

        //插入orderinfo
        String sql1 = "insert into orderinfo values (null,?,?,?,?,?)";
        //插入orderdetails表
        String sql2 = "insert into orderdetails values (null,?,?,?,?)";
        //修改自己的vip信息
        String sql3 = "update vip set jifen =?,money =? ,updateTime = ? where id =?";
        //修改商品信息
        String sql4 = "update product set num =? where id = ?";
        //获取连接
        Connection con = JdbcUtil.getCon();
        //事务成功的判断条件们  sql1Id   返回的Id
        int sql1Id = 0, p = 0, o = 0, q = 0;
        try {
            //手动事务提交
            con.setAutoCommit(false);
            //插入orderinfo
            sql1Id = JdbcUtil.executeInsetId(con, sql1, orderinfo.getVipid(), orderinfo.getPrice(),
                    orderinfo.getOrderdate(), orderinfo.getPaytype(), orderinfo.getMoney());

            //插入orderdetails表
            for (Orderdetails orderdetails : orderDetailsList) {
                o = JdbcUtil.executeInsetId(con, sql2, sql1Id, orderdetails.getProductid(), orderdetails.getNum(), orderdetails.getMoney());
            }
            //修改自己的vip信息
            p = JdbcUtil.executeUpdate(con, sql3, vip.getJifen(), vip.getMoney(),vip.getUpdatetime(), vip.getId());
            //修改商品信息
            for (ProductVO productVO : productVOS) {
                q = JdbcUtil.executeUpdate(con, sql4, productVO.getRemainNum(), productVO.getId());
            }
            //判断唯一的成功条件之后 事务提交
            if (sql1Id > 0 && o > 0 && p > 0 && q > 0) {
                //事务提交
                con.commit();
            } else {
                //事务回滚
                con.rollback();
            }
        } catch (SQLException e) {
            try {
                //事务回滚
                con.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return sql1Id > 0 && o > 0 && p > 0 && q > 0;
    }

    @Override
    public List<Orderdetails> selectOrderDetailByPId(Integer proId) {
        String sql = "select * from orderdetails where productid = ?";
        return JdbcUtil.getAll(sql, Orderdetails.class, proId);
    }

    @Override
    public List<OrderDetailInfo> select2TableByProductId(Integer proId) {
        String sql = "select o1.id        id,\n" +
                "       o1.orderid   orderid,\n" +
                "       o1.productid productid,\n" +
                "       o1.num       num,\n" +
                "       o1.money     money,\n" +
                "       o2.vipid     vipid,\n" +
                "       o2.orderdate orderdate,\n" +
                "       o2.paytype   paytype\n" +
                "from orderdetails o1,\n" +
                "     orderinfo o2\n" +
                "where o1.orderid = o2.id\n" +
                "  and o1.productid = ?";
        return JdbcUtil.getAll(sql, OrderDetailInfo.class, proId);
    }

    @Override
    public List<OrderDetailInfo> select2TableByVipId(Integer VipId) {
        String sql = "select o1.id        id,\n" +
                "       o1.orderid   orderid,\n" +
                "       o1.productid productid,\n" +
                "       o1.num       num,\n" +
                "       o1.money     money,\n" +
                "       o2.vipid     vipid,\n" +
                "       o2.orderdate orderdate,\n" +
                "       o2.paytype   paytype\n" +
                "from orderdetails o1,\n" +
                "     orderinfo o2\n" +
                "where o1.orderid = o2.id\n" +
                "  and o2.vipid = ?";
        return JdbcUtil.getAll(sql, OrderDetailInfo.class, VipId);
    }

    @Override
    public List<OrderDetailInfo> select2TableByPVId(Integer proId, Integer VipId) {
        String sql = "select o1.id        id,\n" +
                "       o1.orderid   orderid,\n" +
                "       o1.productid productid,\n" +
                "       o1.num       num,\n" +
                "       o1.money     money,\n" +
                "       o2.vipid     vipid,\n" +
                "       o2.orderdate orderdate,\n" +
                "       o2.paytype   paytype\n" +
                "from orderdetails o1,\n" +
                "     orderinfo o2\n" +
                "where o1.orderid = o2.id\n" +
                "  and o1.productid = ?" +
                "  and o2.vipid = ?";
        return JdbcUtil.getAll(sql, OrderDetailInfo.class, proId, VipId);

    }

    @Override
    public List<RankProVO> findOrderForRankProductid(Integer month ,Integer typeId) {
        String sql = "select orderdetails.id id, product.pname pname, sum(orderdetails.num) num\n" +
                "from product,\n" +
                "     producttype,\n" +
                "     orderdetails,\n" +
                "     orderinfo\n" +
                "where orderdetails.productid = product.id\n" +
                "  and orderinfo.id = orderdetails.orderid\n" +
                "  and product.typeid = producttype.id\n" +
                "  and month(orderinfo.orderdate) = ?\n" +
                "  and product.typeid = ?\n" +
                "group by orderdetails.productid\n" +
                "order by num desc limit 10";
        return JdbcUtil.getAll(sql, RankProVO.class, month, typeId);
    }

    @Override
    public List<Orderinfo> selectOrderInfoByVId(Integer id) {
        String sql = "select * from orderinfo where vipid = ?";
        return JdbcUtil.getAll(sql, Orderinfo.class, id);
    }

}