package com.chy.test;

import com.chy.constants.UserConstants;
import com.chy.service.ProductService;
import com.chy.service.ProductTypeService;
import com.chy.service.VipService;
import com.chy.service.impl.ProductServiceImpl;
import com.chy.service.impl.ProductTypeServiceImpl;
import com.chy.service.impl.VipServiceImpl;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:00
 * @Since:jdk1.8
 * @Description:TODO
 */
@SuppressWarnings("all")
public class AdminOperation {
    private ProductTypeService productTypeService = new ProductTypeServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private VipService vipService = new VipServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    /**
     * 管理员的登录判断 登陆
     *
     * @return
     */
    public boolean adminLogin() {
        System.out.println("您的操作为管理员权限,请先登录");
        System.out.println("请输入账号:");
        String user = scanner.next();
        System.out.println("请输入密码:");
        String pwd = scanner.next();
        if (user.equals(UserConstants.SUPERUSER_ID) && pwd.equals(UserConstants.SUPERUSER_PWD)) {
            System.out.println("您的身份是管理员身份:");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 管理员的商品类型管理
     */
    public void  productTypeMenu() {
        boolean b = true;
        while (b) {
            System.out.println("您可以操作以下选项");
            System.out.println("1.添加商品类型信息");
            System.out.println("2.修改商品类型信息");
            System.out.println("3.查询商品类型信息");
            System.out.println("4.删除商品类型信息");
            System.out.println("0.返回上一级");
            System.out.println("请选择:");
            switch (scanner.next()) {
                case "1":
                    productTypeService.addProductType();
                    break;
                case "2":
                    productTypeService.updateProductType();
                    break;
                case "3":
                    productTypeService.selectProductType();
                    break;
                case "4":
                    productTypeService.deleteProductType();
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    break;

            }
        }

    }

    /**
     * 管理员的商品管理
     */
    public void productMenu() {
        boolean b = true;
        while (b) {
            System.out.println("您可以操作以下选项");
            System.out.println("1.添加商品信息");
            System.out.println("2.修改商品信息");
            System.out.println("3.查询商品信息");
            System.out.println("4.删除商品信息");
            System.out.println("0.返回上一级");
            System.out.println("请选择:");
            switch (scanner.next()) {
                case "1":
                    productService.addProduct();
                    break;
                case "2":
                    productService.updateProduct();
                    break;
                case "3":
                    productService.selectProduct();
                    break;
                case "4":
                    productService.deleteProduct();
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    break;
            }

        }
    }

    /**
     * 管理员会员管理
     */
    public void vipMenu()  {
        boolean b = true;
        while (b) {
            System.out.println("您可以操作以下选项");
            System.out.println("1.添加会员信息");
            System.out.println("2.修改会员信息");
            System.out.println("3.查询会员信息");
            System.out.println("4.删除会员信息");
            System.out.println("5.会员充值 ");
            System.out.println("0.返回上一级");
            System.out.println("请选择:");
            switch (scanner.next()) {
                case "1":
                    vipService.addVip();
                    break;
                case "2":
                    vipService.updateVip();
                    break;
                case "3":
                    vipService.selectVip();
                    break;
                case "4":
                    vipService.deleteVip();
                    break;
                case "5":
                    vipService.updateVipMoney();
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    break;
            }
        }
    }
}