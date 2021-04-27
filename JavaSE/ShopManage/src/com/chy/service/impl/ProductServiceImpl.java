package com.chy.service.impl;

import com.chy.bean.*;
import com.chy.bean.vo.BuyVO;
import com.chy.bean.vo.ProductVO;
import com.chy.dao.OrderDao;
import com.chy.dao.ProductDao;
import com.chy.dao.ProductTypeDao;
import com.chy.dao.VipDao;
import com.chy.dao.impl.OrderDaoImpl;
import com.chy.dao.impl.ProductDaoImpl;
import com.chy.dao.impl.ProductTypeDaoImpl;
import com.chy.dao.impl.VipDaoImpl;
import com.chy.service.ProductService;
import com.chy.utils.DateUtils;
import com.chy.utils.PageInfoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:34
 * @Since:jdk1.8
 * @Description:
 */

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private Scanner scanner = new Scanner(System.in);
    private VipDao vipDao = new VipDaoImpl();

    @Override
    public void addProduct() {
        //初始化一个商品调用的时候使用
        Product product = new Product();
        System.out.println("请输入商品名称");
        product.setPname(scanner.next());
        System.out.println("请输入商品单价");
        product.setPrice(scanner.nextDouble());

        System.out.println("请输入商品数目");
        product.setNum(scanner.nextInt());

        System.out.println("请输入商品的折扣");
        product.setDiscount(scanner.nextInt());

        System.out.println("请选择商品的类型");
        List<Producttype> producttypes = productTypeDao.selectByFlagParentId(0);
        System.out.println("商品编号\t 类型名称\t");
        producttypes.forEach(c -> System.out.println(c.getId() + "\t" +
                c.getTypename()));
        product.setTypeid(scanner.nextInt());
        System.out.println("请设置商品的初始状态 1为上架，2为下架，3为删除");
        product.setState(scanner.nextInt());
        if (productDao.addProduct(product) > 0) {
            System.out.println("商品添加成功");
        } else {
            System.out.println("商品添加失败");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("请输入删除的商品id");
        int id = scanner.nextInt();
        List<Orderdetails> orderdetailsList = orderDao.selectOrderDetailByPId(id);
        if (orderdetailsList.size() > 0) {
            System.out.println("此商品有过购买记录不能删除 sry");
            return;
        }
        if (productDao.deleteProductById(id) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateProduct() {
        System.out.println("请选择商品编号:");
        int id = scanner.nextInt();
        Product product = productDao.selectProductById(id);
        showProduct(product);
        System.out.println("请输入修改后的商品名称");
        product.setPname(scanner.next());
        System.out.println("请输入修改后的商品单价");
        product.setPrice(scanner.nextDouble());

        System.out.println("请输入修改后的商品数目");
        product.setNum(scanner.nextInt());

        System.out.println("请输入修改后的商品的折扣");
        product.setDiscount(scanner.nextInt());

        System.out.println("请输入修改后的选择商品的类型");
        List<Producttype> producttypes = productTypeDao.selectByFlagParentId(0);
        System.out.println("商品编号\t 类型名称\t");
        producttypes.forEach(c -> System.out.println(c.getId() + "\t" +
                c.getTypename()));
        product.setTypeid(scanner.nextInt());

        while (true) {
            System.out.println("请设置商品的状态 1为上架，2为下架，3为删除");
            List<Orderdetails> orderdetailsList = orderDao.selectOrderDetailByPId(id);
            int status = scanner.nextInt();
            if (status == 3 && orderdetailsList.size() > 0) {
                System.out.println("此商品有过购买记录不能删除 ,请重新设置 ");
            } else {
                product.setState(status);
                break;
            }
        }
        if (productDao.updateProduct(product) > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Override
    public void selectProduct() {
        List<Product> products = productDao.selectAllProduct();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setAllCount(products.size());
        int i = 0;
        while (i != -1) {
            System.out.println("--------第" + (i + 1) + "页----------");
            pageInfo.setPage(i);
            List<Product> products1 = productDao.selectProductByPage(pageInfo);
            System.out.println("商品编号\t商品名称\t商品价格\t商品数目\t商品折扣\t商品的父类id\t商品的状态");
            products1.forEach(this::showProduct);
            i = PageInfoUtils.pageForNextPage(i, pageInfo);
        }
    }

    @Override
    public void jifen() {
        System.out.println("请输入你的会员卡号:");
        String cardNum = scanner.next();
        Vip vip = vipDao.selectByCardNumber(cardNum);
        if (null != vip.getCardnumber() && !"1000".equals(vip.getCardnumber())) {
            if (vip.getJifen() <= 0) {
                System.out.println("您的积分不足");
                return;
            }
            Integer jifen = vip.getJifen();
            System.out.println("您目前的积分有:" + jifen);
            List<Product> products1 = productDao.selectAllProduct();
            products1 = products1.stream().filter(c -> c.getPrice() < (jifen / 10)).collect(Collectors.toList());
            if (products1.size() == 0) {
                System.out.println("积分不足兑换规则");
                return;
            }
            System.out.println("我们的积分兑换方式是10积分对一元的机制,每次只能兑换一种 商品哦!您可以在商店中选择您的商品");
            System.out.println("商品编号\t商品名称\t商品价格\t商品数目\t商品折扣\t商品的父类id\t商品的状态");
            products1.forEach(this::showProduct);
            System.out.println("请输入你要兑换的商品编号:");
            int id = scanner.nextInt();
            Product product = productDao.selectProductById(id);
            if (product.getId() == null) {
                System.out.println("不存在的商品");
                return;
            }
            System.out.println("请输入数量");
            int num = scanner.nextInt();
            if (num > product.getNum()) {
                System.out.println("超过库存 ");
                return;
            }
            if (product.getPrice() * num > jifen / 10) {
                System.out.println("您的积分不足:");
            } else {
                System.out.println("您已选择" + product.getPname() + " " + num + "件");
                System.out.println("是否确认兑换 1,确认 0.退出  ");
                String choose = scanner.next();
                switch (choose) {
                    case "1":
                        double price = (product.getPrice() * num);
                        vip.setJifen((int) (vip.getJifen() - product.getPrice() * num * 10));
                        int remian = product.getNum() - num;
                        jifenBuy(id, num, remian, vip,price);
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("非法输入");
                        break;
                }
            }
        } else {
            System.out.println("此会员卡号暂不支持活动");
        }
    }

    /**
     * 积分购买
     * @param id
     * @param num
     * @param remian
     * @param vip
     * @param price
     */
    private void jifenBuy(int id, int num, int remian, Vip vip ,double price) {
        // 准备数据
        //用于修改统一修改数据库时的数据传输
        BuyVO buyVO = new BuyVO();
        List<ProductVO> productVOS = new ArrayList<>();
        //详细订单的列表 详细订单是按照
        List<Orderdetails> orderDetailsList = new ArrayList<>();
        //简要订单记录
        Orderinfo orderinfo = new Orderinfo();

        orderinfo.setOrderdate(DateUtils.getNow());
        orderinfo.setMoney(price);
        orderinfo.setVipid(vip.getId());
        orderinfo.setPaytype(3);

        ProductVO productVO = new ProductVO();
        productVO.setId(id);
        productVO.setRemainNum(remian);
        productVOS.add(productVO);

        Orderdetails orderdetails = new Orderdetails();
        orderdetails.setProductid(id);
        orderdetails.setNum(num);
        orderdetails.setMoney(price);
        orderDetailsList.add(orderdetails);
        vip.setUpdatetime(DateUtils.getNow());
        buyVO.setOrderDetailsList(orderDetailsList);
        buyVO.setOrderinfo(orderinfo);
        buyVO.setProductVOS(productVOS);
        buyVO.setVip(vip);
        if (orderDao.buy4TableAlert(buyVO)) {
            System.out.println("兑换成功,积分扣除成功");
        } else {
            System.out.println("oh god please no error!!!");
        }
    }

    /**
     * 显示商品
     *
     * @param product
     */
    private void showProduct(Product product) {
        System.out.println(product.getId() + "\t" +
                product.getPname() + "\t" + "\t" +
                product.getPrice() + "\t" +
                product.getNum() + "\t" + "\t" +
                product.getDiscount() + "\t" + "\t" +
                showParent(product.getTypeid()) + "\t" + "\t" +
                    productStateJug(product.getState()));
    }

    /**
     * 商品展示的状态判断
     *
     * @param state
     * @return
     */
    private String productStateJug(int state) {
        String res = "";
        switch (state) {
            case 1:
                res = "上架";
                break;
            case 2:
                res = "下架";
                break;
            case 3:
                res = "删除";
                break;
            default:
                break;
        }
        return res;
    }


    private String showParent(int typeId) {
        Producttype producttype = productTypeDao.selectById(typeId);
        return producttype.getTypename();
    }
}