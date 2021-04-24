package com.chy.service.impl;

import com.chy.bean.*;
import com.chy.bean.vo.BuyVO;
import com.chy.bean.vo.OrderDetailInfo;
import com.chy.bean.vo.ProductVO;
import com.chy.bean.vo.RankProVO;
import com.chy.dao.OrderDao;
import com.chy.dao.ProductDao;
import com.chy.dao.ProductTypeDao;
import com.chy.dao.VipDao;
import com.chy.dao.impl.OrderDaoImpl;
import com.chy.dao.impl.ProductDaoImpl;
import com.chy.dao.impl.ProductTypeDaoImpl;
import com.chy.dao.impl.VipDaoImpl;
import com.chy.service.OrderService;
import com.chy.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/22-16:11
 * @Since:jdk1.8
 * @Description:
 */

public class OrderServiceImpl implements OrderService {
    private Scanner scanner = new Scanner(System.in);
    private ProductDao productDao = new ProductDaoImpl();
    private VipDao vipDao = new VipDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();


    @Override
    public void addProduct(Map<Integer, Integer> buyCar) {
        List<Product> productForAll = productDao.selectAllProduct();
        System.out.println("商品编号\t商品名称\t商品价格\t商品数目\t商品折扣\t商品的父类id\t商品的状态");
        productForAll.forEach(this::showProduct);
        System.out.println("请输入商品Id");
        int id = scanner.nextInt();
        //判断重复id map
        if (buyCar.containsKey(id)) {
            System.out.println("购物车已有此商品,如果需要请返回重新修改数量");
            return;
        }
        Product product = productDao.selectProductById(id);
        System.out.println("商品编号\t商品名称\t商品价格\t商品数目\t商品折扣\t商品的父类id\t商品的状态");
        showProduct(product);
        //判断状态 是否是可以买的
        if (product.getState() == 1) {
            System.out.println("请输入购买数量");
            int num = scanner.nextInt();
            //判断数量 是否可以购买
            if (num <= product.getNum()) {
                buyCar.put(id, num);
                showProduct(buyCar);
            } else {
                System.out.println("超出购买数量");
            }
        } else {
            System.out.println("暂时不能买");
        }
    }

    @Override
    public void deleteProduct(Map<Integer, Integer> buyCar) {
        System.out.println("请输入你要移除的商品id");
        int id = scanner.nextInt();
        if (buyCar.containsKey(id)) {
            buyCar.remove(id);
        } else {
            System.out.println("购物车中没有此商品");
        }
    }

    @Override
    public void updateProduct(Map<Integer, Integer> buyCar) {
        System.out.println("请输入你要修改的商品id");
        int id = scanner.nextInt();
        Product product = productDao.selectProductById(id);
        System.out.println("请输入修改后的数量");
        int num = scanner.nextInt();
        //判断数量 是否可以购买
        if (num < product.getNum()) {
            buyCar.replace(id, num);
        } else {
            System.out.println("超出总量了");
        }
    }

    @Override
    public void showProduct(Map<Integer, Integer> buyCar) {
        System.out.println("商品Id\t商品名称\t选择数量\t购物车总价");
        for (Integer key : buyCar.keySet()) {
            //数目
            Integer num = buyCar.get(key);
            Product product = productDao.selectProductById(key);
            String pname =product.getPname();
            Double price = product.getPrice()*num;
            System.out.println(key + "\t" + pname + "\t" + num+ "\t" + price);
        }
    }

    @Override
    public void pay(Map<Integer, Integer> buyCar) {
        //用于修改统一修改数据库时的数据传输
        BuyVO buyVO = new BuyVO();
        List<ProductVO> productVOS = new ArrayList<>();
        //详细订单的列表 详细订单是按照
        List<Orderdetails> orderDetailsList = new ArrayList<>();
        //简要订单记录
        Orderinfo orderinfo = new Orderinfo();

        // 计算总金额
        double allpay = 0;
        //会员价格
        double allMoneyForVip = 0;
        for (Integer key : buyCar.keySet()) {
            Integer buyNum = buyCar.get(key);
            //商品的详细订单
            Orderdetails orderdetails = new Orderdetails();
            // 商品的修改信息
            ProductVO productVO = new ProductVO();

            Product product = productDao.selectProductById(key);
            double pay = product.getPrice() * buyNum;
            double pay2 = pay * (1 - 0.01 * product.getDiscount());
            allpay += pay;
            allMoneyForVip += pay2;
            //添加修改的商品信息
            productVO.setId(key);
            productVO.setRemainNum(product.getNum() - buyNum);
            productVOS.add(productVO);
            // 按照商品的Id 划分的详细定订单表  剩下的信息是在
            orderdetails.setProductid(key);
            orderdetails.setNum(buyNum);
            orderdetails.setMoney(pay);

            orderDetailsList.add(orderdetails);
        }

        orderinfo.setOrderdate(DateUtils.getNow());
        orderinfo.setMoney(allpay);
        System.out.println("您一共需要支付" + allpay + "元");
        System.out.println("是否使用会员卡支付1.是\t其他.不是");
        String choose = scanner.next();
        if ("1".equals(choose)) {
            System.out.println("请输入会员卡号:");
            String cardNum = scanner.next();
            Vip vip = vipDao.selectByCardNumber(cardNum);
            if (null != vip.getCardnumber() && !vip.getCardnumber().equals("1000")) {
                orderinfo.setVipid(vip.getId());
                orderinfo.setPaytype(2);
                //判断 余额
                if (vip.getMoney() < allpay) {
                    //循环充值 直到金额足够
                    while (true) {
                        System.out.println("您的会员卡余额不足 请充值:");
                        System.out.println("请输入充值的金额");
                        int money = scanner.nextInt();
                        double allMoneyOfVip = 0;
                        allMoneyOfVip = vip.getMoney() + money + allMoneyOfVip;
                        if (allMoneyOfVip >= allMoneyForVip) {
                            vip.setMoney(allMoneyOfVip);
                            vipDao.updateVip(vip);
                            break;
                        }
                    }
                }
                vip.setMoney(vip.getMoney() - allMoneyForVip);
                vip.setJifen((int) (vip.getJifen() + allpay));
                vip.setUpdatetime(DateUtils.getNow());
                buyVO.setVip(vip);
            } else {
                System.out.println("此卡号不存在,使用默认的未办理会员的Id");

                orderinfo.setVipid(1);
            }
        } else {
            System.out.println("请现金支付" + allpay + "元");
            //数据库默认的未办理会员的会员编号
            //默认会员  1000
            Vip vip = vipDao.selectVipById(1);

            vip.setMoney(vip.getMoney() + allpay);
            vip.setJifen((int) (vip.getJifen() + allpay));
            vip.setUpdatetime(DateUtils.getNow());
            buyVO.setVip(vip);

            orderinfo.setVipid(1);
            orderinfo.setPaytype(1);
        }

        buyVO.setOrderDetailsList(orderDetailsList);
        buyVO.setOrderinfo(orderinfo);
        buyVO.setProductVOS(productVOS);

        if (orderDao.buy4TableAlert(buyVO)) {
            System.out.println("购买成功,付款成功");
        } else {
            System.out.println("oh god please no error!!!");
        }
    }

    @Override
    public void orderManageByPid() {
        System.out.println("请输入商品id");
        int pid = scanner.nextInt();
        List<OrderDetailInfo> orderDetailInfos = orderDao.select2TableByProductId(pid);
        if (orderDetailInfos.size() > 0) {
            System.out.println("详细Id\tinfoID\t商品名\t商品数量\t付款金额\t会员账号\t订单日期\t\t付款方式\t");
            orderDetailInfos.forEach(this::showOrderDetailInfo);
        } else {
            System.out.println("此商品暂无订单");
        }
    }

    @Override
    public void orderManageByVid() {
        System.out.println("请输入会员id");
        int vid = scanner.nextInt();
        List<OrderDetailInfo> orderDetailInfos = orderDao.select2TableByVipId(vid);
        if (orderDetailInfos.size() > 0) {
            System.out.println("详细Id\tinfoID\t商品名\t商品数量\t付款金额\t会员编号\t订单日期\t\t付款方式\t");
            orderDetailInfos.forEach(this::showOrderDetailInfo);
        } else {
            System.out.println("此会员暂无订单");
        }
    }

    @Override
    public void orderManageByPidVid() {
        System.out.println("请输入商品id");
        int pid = scanner.nextInt();
        System.out.println("请输入会员id");
        int vid = scanner.nextInt();
        List<OrderDetailInfo> orderDetailInfos = orderDao.select2TableByPVId(pid, vid);
        if (orderDetailInfos.size() > 0) {
            System.out.println("详细Id\tinfoID\t商品名\t商品数量\t付款金额\t会员编号\t订单日期\t\t付款方式\t");
            orderDetailInfos.forEach(this::showOrderDetailInfo);
        } else {
            System.out.println("此会员下的商品暂无订单");
        }
    }

    @Override
    public void rankByPM() {
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        System.out.println("请选择商品类型");
        System.out.println("请选择商品的类型");
        List<Producttype> producttypes = productTypeDao.selectByFlagParentId(0);
        System.out.println("商品编号\t 类型名称\t");
        producttypes.forEach(c -> System.out.println(c.getId() + "\t" +
                c.getTypename()));
        int typeId = scanner.nextInt();
        List<RankProVO> orderForRankProductid = orderDao.findOrderForRankProductid(month, typeId);
        System.out.println("商品Id\t商品名\t购买次数");
        for (RankProVO rankProVO : orderForRankProductid) {
            Integer proId = rankProVO.getId();
            String pname = rankProVO.getPname();
            System.out.println(proId + "\t  " + pname + "\t" + rankProVO.getNum());
        }
    }

    /**
     * 展示商品
     *
     * @param product
     */
    private void showProduct(Product product) {
        System.out.println(product.getId() + "\t" +
                product.getPname() + "\t" + "\t" +
                product.getPrice() + "\t" +
                product.getNum() + "\t" + "\t" +
                product.getDiscount() + "\t" + "\t" +
                product.getTypeid() + "\t" + "\t" +
                productStateJug(product.getState()));
    }

    /**
     * 判断 商品的状态
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

    /**
     * 显示订单信息
     *
     * @param orderDetailInfo
     */
    private void showOrderDetailInfo(OrderDetailInfo orderDetailInfo) {

        System.out.println(orderDetailInfo.getId() + "\t" + "\t" +
                orderDetailInfo.getOrderid() + "\t" + "\t" +
                proIdToName(orderDetailInfo.getProductid()) + "\t" + "\t" + "\t" +
                orderDetailInfo.getNum() + "\t" +
                orderDetailInfo.getMoney() + "\t" +
                orderDetailInfo.getVipid() + "\t" + "\t" +
                DateUtils.dataFormate(orderDetailInfo.getOrderdate()) + "\t" +
                payTypeJug(orderDetailInfo.getPaytype()));
    }

    /**
     * 判断支付类型
     * @param payType
     * @return
     */
    private String payTypeJug(int payType) {
        String res = "";
        if (payType == 1) {
            res = "现金";
        }
        if (payType == 2) {
            res = "卡内余额";
        }
        return res;
    }

    /**
     * 商品id转商品名
     * @param id
     * @return
     */
    private String proIdToName(Integer id) {
        String res = "";
        Product product = productDao.selectProductById(id);
        if (product.getId() != null) {
            res = product.getPname();
        }
        return res;
    }
}