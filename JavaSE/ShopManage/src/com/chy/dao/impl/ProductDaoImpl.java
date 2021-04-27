package com.chy.dao.impl;

import com.chy.bean.PageInfo;
import com.chy.bean.Product;
import com.chy.dao.ProductDao;
import com.chy.utils.JdbcUtil;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-9:45
 * @Since:jdk1.8
 * @Description:TODO
 */

public class ProductDaoImpl implements ProductDao {
    @Override
    public int addProduct(Product product) {
        String sql = "INSERT INTO product VALUES (null, ?, ?, ?,?,?,?)";
        return  JdbcUtil.executeUpdate(sql, product.getPname(), product.getPrice(), product.getNum(), product.getDiscount(), product.getTypeid(), product.getState());
    }

    @Override
    public List<Product> selectAllProduct() {
        String sql = "select * from product ";
        return JdbcUtil.getAll(sql, Product.class);
    }

    @Override
    public Product selectProductById(Integer id) {
        String sql = "select * from product where  id = ?";
        return JdbcUtil.getById(sql, Product.class, id);
    }

    @Override
    public int deleteProductById(Integer id) {
        String sql = "update product set state = 3 where id = ?";
        return JdbcUtil.executeUpdate(sql, id);
    }

    @Override
    public int updateProduct(Product product) {
        String sql = "update product set  pname =?,price = ?,num=?,discount = ?,typeid = ?,state = ? where id = ?";
        return JdbcUtil.executeUpdate(sql, product.getPname(), product.getPrice(), product.getNum(),
                product.getDiscount(), product.getTypeid(), product.getState(), product.getId());
    }

    @Override
    public List<Product> selectProductByPage(PageInfo pageInfo) {
        String sql = "select * from product limit ?,?";
        return JdbcUtil.getAll(sql, Product.class,pageInfo.getPage()*pageInfo.getCount(),pageInfo.getCount());
    }

    @Override
    public List<Product> selectByTypeId(Integer typeId) {
        String sql = "select * from product where typeid = ? ";
        return JdbcUtil.getAll(sql, Product.class, typeId);
    }
}