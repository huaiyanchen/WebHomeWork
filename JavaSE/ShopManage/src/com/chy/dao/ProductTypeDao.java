package com.chy.dao;

import com.chy.bean.Producttype;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:40
 * @Since:jdk1.8
 * @Description:TODO
 */

public interface ProductTypeDao {
    /**
     * @author: chy
     * @Date: 2021/4/21 20:30
     * @Description: 添加
     */
    int addProductType(Producttype producttype);

    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 删除
     */
    int  deleteProductType(Integer id);
    /**
     *  @author: chy
     *  @Date: 2021/4/21 20:30
     *  @Description: 修改
     */
    int  updateProductType(Producttype producttype);

    /**
     * @author: chy
     * @Date: 2021/4/21 20:31
     * @Description: 查询所有
     */
    List<Producttype> selectAllProductType();

    /**
     * 根据时候是父类还是子类查询商品类型列表
     * @param id
     * @return
     */
    List<Producttype> selectByFlagParentId(Integer id);

    /**
     * 根据父类查所有的子类
     * @param id
     * @return
     */
    List<Producttype> selectByParentId(Integer id);

    /**
     * 根据id查一个
     * @param id
     * @return
     */
    Producttype selectById(Integer id);


}