package com.chy.dao.impl;

import com.chy.bean.Vip;
import com.chy.dao.VipDao;
import com.chy.utils.JdbcUtil;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-11:07
 * @Since:jdk1.8
 * @Description:TODO
 */

public class VipDaoImpl implements VipDao {
    @Override
    public int addVip(Vip vip) {
        String sql = "insert into vip  values(null,?,?,?,?,?,?,?)";
        return JdbcUtil.executeUpdate(sql, vip.getCardnumber(), vip.getVipname(), vip.getIphone(),
                vip.getJifen(), vip.getMoney(), vip.getCreatetime(), vip.getCreatetime());
    }

    @Override
    public int deleteVipById(Integer id) {
        String sql = "delete from vip where id = ?";
        return JdbcUtil.executeUpdate(sql, id);
    }

    @Override
    public int updateVip(Vip vip) {
        String sql = "update vip set vipname=? ,iphone =? ,jifen=?,money =?,updateTime = ? where id =?";

        return JdbcUtil.executeUpdate(sql, vip.getVipname(), vip.getIphone(), vip.getJifen(), vip.getMoney(),
                vip.getUpdatetime(), vip.getId());
    }

    @Override
    public Vip selectVipById(Integer id) {
        String sql = "select * from  vip  where id = ?";

        return JdbcUtil.getById(sql, Vip.class, id);
    }

    @Override
    public Vip selectByCardNumber(String cardNumber) {
        String sql = "select * from  vip  where cardnumber = ?";
        return JdbcUtil.getById(sql, Vip.class, cardNumber);
    }

    @Override
    public List<Vip> selectAllVip() {
        String sql = "select * from  vip";
        return JdbcUtil.getAll(sql, Vip.class);
    }

    @Override
    public Vip selectMaxIdForCardNum() {
        String sql = "select * from vip order by cardnumber desc limit 1";
        List<Vip> all = JdbcUtil.getAll(sql, Vip.class);
        return all.get(0);
    }
}