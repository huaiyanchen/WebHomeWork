package com.chy.service.impl;

import com.chy.bean.Vip;
import com.chy.dao.VipDao;
import com.chy.dao.impl.VipDaoImpl;
import com.chy.service.VipService;
import com.chy.utils.DateUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-20:36
 * @Since:jdk1.8
 * @Description:
 */

public class VipServiceImpl implements VipService {

    private Scanner scanner = new Scanner(System.in);
    private VipDao vipDao = new VipDaoImpl();

    @Override
    public void addVip() {
        Vip vip = new Vip();
        Vip vip1 = vipDao.selectMaxIdForCardNum();
        vip.setCardnumber(vip1.getCardnumber() + 1);
        System.out.println("请输入会员姓名:");
        vip.setVipname(scanner.next());
        System.out.println("请输入会员的手机号");
        vip.setIphone(scanner.next());
        vip.setCreatetime(DateUtils.getNow());
        vip.setUpdatetime(DateUtils.getNow());
        if (vipDao.addVip(vip) > 0) {
            System.out.println("注册成功!!!\n会员卡号为:");
            System.out.println(vip.getCardnumber());
        } else {
            System.out.println("注册失败");
        }
    }

    @Override
    public void deleteVip() {
        System.out.println("请输入要删除会员的id");
        if (vipDao.deleteVipById(scanner.nextInt()) > 0) {
            System.out.println("删除会员成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateVip() {
        System.out.println("请输入要修改的编号");
        Vip vip = vipDao.selectVipById(scanner.nextInt());
        System.out.println("编号\t会员卡号\t手机号码\t\t积分\t余额\t\t开通会员时间\t\t\t修改时间");
        showVip(vip);
        System.out.println("请输入修改后的会员姓名");
        vip.setVipname(scanner.next());
        System.out.println("请输入修改后的会员手机号:");
        vip.setIphone(scanner.next());
        vip.setUpdatetime(DateUtils.getNow());
        if (vipDao.updateVip(vip) > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }


    }

    @Override
    public void selectVip() {
        System.out.println("编号\t会员卡号\t手机号码\t\t积分\t余额\t\t开通会员时间\t\t\t修改时间");
        List<Vip> vips = vipDao.selectAllVip();
        vips.forEach(this::showVip);

    }

    @Override
    public void updateVipMoney() {
        //会员充值
        System.out.println("请输入要充值的会员卡号(会员卡号哦!)");
        Vip vip = vipDao.selectByCardNumber(scanner.next());
        System.out.println("编号\t会员卡号\t手机号码\t\t积分\t余额\t\t开通会员时间\t\t\t修改时间");
        showVip(vip);
        System.out.println("请输入要充值的金额:");
        vip.setMoney(vip.getMoney() + scanner.nextDouble());
        vip.setUpdatetime(DateUtils.getNow());

        if (vipDao.updateVip(vip) > 0) {
            System.out.println("充值成功\n现在的卡余额为:" + vip.getMoney());
        } else {
            System.out.println("充值失败");
        }
    }

    /**
     * 显示会员信息的私有公共方法
     * @param vip
     */
    private void showVip(Vip vip) {
        System.out.println(vip.getId() +"\t"+
                vip.getCardnumber() +"\t"+
                vip.getIphone() +"\t"+
                vip.getJifen() +"\t"+
                vip.getMoney() +"\t"+
                DateUtils.dataFormate(vip.getCreatetime()) +"\t"+
                DateUtils.dataFormate(vip.getUpdatetime()));
    }
}