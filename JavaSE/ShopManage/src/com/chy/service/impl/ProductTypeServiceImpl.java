package com.chy.service.impl;

import com.chy.bean.Product;
import com.chy.bean.Producttype;
import com.chy.dao.ProductDao;
import com.chy.dao.ProductTypeDao;
import com.chy.dao.impl.ProductDaoImpl;
import com.chy.dao.impl.ProductTypeDaoImpl;
import com.chy.service.ProductTypeService;
import com.chy.utils.DateUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:29
 * @Since:jdk1.8
 * @Description:
 */

public class ProductTypeServiceImpl implements ProductTypeService {
    private Scanner scanner = new Scanner(System.in);
    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();


    @Override
    public void addProductType() {
        Producttype producttype = new Producttype();
        System.out.println("请判断你添加的商品是不是父类商品 1,父类 2.子类 ");
        String choose = scanner.next();
        //是否是父类
        int flagparent = -1;
        //父类的id
        int parentId = -1;
        if ("1".equals(choose)) {
            //是父类
            flagparent = 1;
            parentId = 0;
        } else if ("2".equals(choose)) {
            List<Producttype> producttypes = productTypeDao.selectByFlagParentId(1);
            System.out.println("商品类型编号\t类型名称\t");
            producttypes.forEach(c -> System.out.println(c.getId() + "\t" +
                    c.getTypename()));

            System.out.println("请选择:");
            int i = scanner.nextInt();
            flagparent = 0;
            parentId = i;
        } else {
            System.out.println("输入错误 ");
            return;
        }
        producttype.setFlagparent(flagparent);
        System.out.println("请输入类型名:");
        producttype.setTypename(scanner.next());
        producttype.setParentid(parentId);
        producttype.setCreatetime(DateUtils.getNow());
        int i = productTypeDao.addProductType(producttype);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失敗");
        }
    }

    @Override
    public void deleteProductType() {
        System.out.println("请输入删除的商品类型的id");
        int id = scanner.nextInt();
        Producttype producttype = productTypeDao.selectById(id);
        if (producttype.getFlagparent() == 1) {
            System.out.println("是一级分类商品不能删除");
            return;
        }
        if (checkIsHavePro(producttype.getId())) {
            System.out.println("有子类商品不能删除");
            return;
        }
        if (productTypeDao.deleteProductType(id) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateProductType() {
        System.out.println("请输入你要修改的id");
        //获取修改的商品
        Producttype producttype = productTypeDao.selectById(scanner.nextInt());
        //父类商品列表
        List<Producttype> producttypes = productTypeDao.selectByFlagParentId(1);
        //if 存在自己本身 remove  因为remove底层做了判断 所以不用手动判断
        producttypes.remove(producttype);
        System.out.println("商品类型编号\t父类id\t类型名称\t是否是父类\t创建时间\t更新时间");
        System.out.println(producttype.getId() + "\t" + producttype.getParentid() + "\t" +
                producttype.getTypename() + "\t" + producttype.getFlagparent() + "\t" + DateUtils.dataFormate(producttype.getCreatetime()) + "\t" +
                DateUtils.dataFormate(producttype.getUpdatetime()));
        System.out.println("请输入要修改的商品类型名");
        producttype.setTypename(scanner.next());
        // 是父类
        if (producttype.getFlagparent() == 1) {
            List<Producttype> producttypes1 = productTypeDao.selectAllProductType();
            for (Producttype producttype1 : producttypes1) {
                if (producttype1.getParentid().equals(producttype.getId())) {
                    System.out.println("您有儿子了 不能改了 ");
                    return;
                }
            }
            System.out.println("是否修改为子类 1.不修改 0.修改");
            int i = scanner.nextInt();
            producttype.setFlagparent(i);
            // 修改 显示父类id
            if (i == 0) {
                System.out.println("商品类型编号\t类型名称\t");
                producttypes.forEach(c -> System.out.println(c.getId() + "\t" +
                        c.getTypename()));
                System.out.println("请选择父类的id:");
                producttype.setParentid(scanner.nextInt());
            }
        }
        // 是子类
        else if (producttype.getFlagparent() == 0) {
            System.out.println("是否修改为父类 0.不修改 1.修改");
            int i = scanner.nextInt();
            producttype.setFlagparent(i);
            // 修改 显示父类id
            if (i == 1) {
                producttype.setParentid(0);
            }
        }

        producttype.setUpdatetime(DateUtils.getNow());
        int i = productTypeDao.updateProductType(producttype);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Override
    public void selectProductType() {
        //父类商品列表
        List<Producttype> producttypes = productTypeDao.selectByFlagParentId(1);
        showProductType(producttypes);
        while (true) {
            System.out.println("请选择父类的id ,按0返回上一级");
            int id = scanner.nextInt();
            if (id ==  0) {
                break;
            }
            List<Producttype> producttypes1 = productTypeDao.selectByParentId(id);
            showProductType(producttypes1);

        }

    }

    /**
     * @author: chy
     * @Date: 2021/4/21 21:14
     * @Description: 显示
     */
    private void showProductType(List<Producttype> producttypes) {

        System.out.println("类型编号\t父类id\t类型名称\t是否是父类\t创建时间\t更新时间");
        producttypes.forEach(c -> System.out.println(c.getId() + "\t" + showParent(c.getParentid()) + "\t" +
                c.getTypename() + "\t" + c.getFlagparent() + "\t" + DateUtils.dataFormate(c.getCreatetime()) + "\t" +
                DateUtils.dataFormate(c.getUpdatetime())));

    }

    /**
     * 判断是否有子类商品
     *
     * @param id
     * @return
     */
    private boolean checkIsHavePro(Integer id) {
        List<Product> products = productDao.selectByTypeId(id);
        return products.size() > 0;
    }

    public String showParent(int pId) {
        if (pId == 0) {
            return "一级父类";
        }
        Producttype producttype = productTypeDao.selectById(pId);
        return producttype.getTypename();
    }
}