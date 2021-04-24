package com.chy.dao.impl;

import com.chy.bean.Producttype;
import com.chy.dao.ProductTypeDao;
import com.chy.utils.JdbcUtil;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:41
 * @Since:jdk1.8
 * @Description:TODO
 */

public class ProductTypeDaoImpl implements ProductTypeDao {
    @Override
    public int addProductType(Producttype producttype) {
        String sql = "insert into producttype values (null,?,?,?,?,?)";
        return JdbcUtil.executeUpdate(sql, producttype.getParentid(), producttype.getTypename(), producttype.getFlagparent(), producttype.getCreatetime(), producttype.getCreatetime());
    }

    @Override
    public int deleteProductType(Integer id) {
        String sql = "delete from producttype where id = ? ";
        return JdbcUtil.executeUpdate(sql,id);

    }

    @Override
    public int updateProductType(Producttype producttype) {
        String sql = "update producttype set Parentid = ?,typename = ? ,flagparent = ? ,updateTime =? where id = ?";
        return JdbcUtil.executeUpdate(sql, producttype.getParentid(), producttype.getTypename(), producttype.getFlagparent(),
                producttype.getUpdatetime(), producttype.getId());
    }


    @Override
    public List<Producttype> selectAllProductType() {
        String sql = "select * from producttype";
        return JdbcUtil.getAll(sql, Producttype.class);
    }


    @Override
    public List<Producttype> selectByFlagParentId(Integer id) {
        String sql = "select * from producttype where flagparent = ? ";
        return JdbcUtil.getAll(sql, Producttype.class, id);
    }

    @Override
    public List<Producttype> selectByParentId(Integer id) {
        String sql = "select * from producttype where Parentid = ? ";
        return JdbcUtil.getAll(sql, Producttype.class, id);
    }

    @Override
    public Producttype selectById(Integer id) {
        String sql = "select * from producttype where id = ? ";
        return JdbcUtil.getById(sql, Producttype.class, id);
    }

}