package com.chy.dao;

import com.chy.bean.PageInfo;
import com.chy.bean.Product;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:40
 * @Since:jdk1.8
 * @Description:
 */
public interface ProductDao {
    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 查询所有商品
     *
     * @return
     */
    List<Product> selectAllProduct();

    /**
     * 根据商品id查询 单个商品
     *
     * @param id
     * @return
     */
    Product selectProductById(Integer id);


    /**
     * 根据商品id删除商品
     *
     * @param id
     * @return
     */
    int deleteProductById(Integer id);

    /**
     * 修改商品信息
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     */
    List<Product> selectProductByPage(PageInfo pageInfo);

    /**
     * 根据商品类型id查询
     * @param typeId
     * @return
     */
    List<Product> selectByTypeId(Integer typeId);

}


