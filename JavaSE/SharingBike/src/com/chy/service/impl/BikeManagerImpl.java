package com.chy.service.impl;

import com.chy.bean.*;
import com.chy.service.BikeManager;
import com.chy.utils.BikeUtils;
import com.chy.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static com.chy.constants.BikeConstants.*;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-11:45
 * @Since:jdk1.8
 * @Description:
 */
public class BikeManagerImpl implements BikeManager {

    //输出
    static void prt(String s) {
        System.out.println(s);
    }

    //输入
    static Scanner sc = new Scanner(System.in);

    static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //投放
    @Override
    public SharedBikeCompany[] addBikes(SharedBikeCompany[] companies) {
        prt("------>1.投放bike");
        showTitles();
        int addInput = sc.nextInt() - 1;
        prt("请选择要投放的数量:");
        int numsInput = sc.nextInt();
        //sum 公司单车总量
        companies[addInput].setSum(companies[addInput].getSum() + numsInput);
        //公司持有共享单车
        int sum = companies[addInput].getSharedBikes().length;
        int lastBid = companies[addInput].getSharedBikes()[sum - 1].getBid();

        SharedBike[] sharedBikes;
        switch (addInput + 1) {
            case 1:
                for (int i = 0; i < numsInput; i++) {
                    OfoBike bike = new OfoBike((lastBid + i + 1), "ofo" + (sum + i + 1), 1, null, null);
                    //坑
                    sharedBikes = Arrays.copyOf(companies[addInput].getSharedBikes(), (companies[addInput].getSharedBikes().length + 1));
                    sharedBikes[sum + i] = bike;
                    companies[addInput].setSharedBikes(sharedBikes);
                }
                break;
            case 2:
                for (int i = 0; i < numsInput; i++) {
                    HaloBike bike = new HaloBike((lastBid + i + 1), "Halo" + (sum + i + 1), 1, null, null);
                    sharedBikes = Arrays.copyOf(companies[addInput].getSharedBikes(), companies[addInput].getSharedBikes().length + 1);
                    sharedBikes[sum + i] = bike;
                    companies[addInput].setSharedBikes(sharedBikes);
                }
                break;
            case 3:
                for (int i = 0; i < numsInput; i++) {
                    MoBaiBike bike = new MoBaiBike((lastBid + i + 1), "MoBai" + (sum + i + 1), 1, null, null);
                    sharedBikes = Arrays.copyOf(companies[addInput].getSharedBikes(), companies[addInput].getSharedBikes().length + 1);
                    sharedBikes[sum + i] = bike;
                    companies[addInput].setSharedBikes(sharedBikes);
                }
                break;
            default:
                break;
        }
        prt("空间不足，已经参照配置进行扩容");
        prt("投放" + numsInput + "辆" + companies[addInput].getBikeCompanyName() + "单车成功:");
        return companies;
    }

    //查看bikes
    @Override
    public void showBikes(SharedBikeCompany[] companies) {
        prt("---->查看所有的Bike信息");
        for (SharedBikeCompany company : companies) {
            prt("序号\t\t名称\t\t单车数量\t借出次数");
            prt(company.getBikeCompanyId() + "\t\t" + company.getBikeCompanyName()
                    + "\t\t" + company.getSum() + "\t\t" + company.getCount());
            SharedBike[] bikes = company.getSharedBikes();
            prt("单车序号\t单车名称\t单车状态\t借出时间\t归还时间");
            for (SharedBike bike : bikes) {
                showBikes(bike);
            }
        }
    }

    //删除
    @Override
    public SharedBikeCompany[] deleteBikes(SharedBikeCompany[] companies) {
        prt("------>3.删除bike");
        showTitles();
        int deleteInput = sc.nextInt() - 1;
        prt("此" + companies[deleteInput].getBikeCompanyName() + "单车下有共享单车如下:");
        SharedBike[] sharedBikes = companies[deleteInput].getSharedBikes();
        prt("单车序号\t单车名称\t单车状态\t\t借出时间\t\t归还时间");
        for (SharedBike bike : sharedBikes) {
            showBikes(bike);
        }
        prt("请输入要删除单车的序号:");
        int inputBid = sc.nextInt();
        String deleteName = "";
        int deleteCur = 0;
        for (int i = 0; i < sharedBikes.length; i++) {
            if (sharedBikes[i].getBid() == inputBid) {
                deleteName = sharedBikes[i].getBname();
                deleteCur = i;
            }
        }
        for (int i = deleteCur; i < sharedBikes.length - 1; i++) {
            sharedBikes[i] = sharedBikes[i + 1];

        }
        sharedBikes = Arrays.copyOf(sharedBikes, sharedBikes.length - 1);
        companies[deleteInput].setSharedBikes(sharedBikes);
        prt("删除" + companies[deleteInput].getBikeCompanyName() + "下的" + deleteName + "成功");
        return companies;
    }

    //借出
    @Override
    public SharedBikeCompany[] rentBikes(SharedBikeCompany[] companies) {
        prt("------>4.借出bike");
        showTitles();
        //坑 要减一 艹
        int rentInput = sc.nextInt() - 1;
        prt("此" + companies[rentInput].getBikeCompanyName() + "单车下有共享单车如下:");
        SharedBike[] sharedBikes = companies[rentInput].getSharedBikes();
        prt("单车序号\t单车名称\t\t单车状态\t\tt借出时间\t\t归还时间");
        for (SharedBike bike : sharedBikes) {
            //如果状态为已借出 ,不显示
            if (bike.getStatus() == 1) {
                showBikes(bike);
            }
        }
        prt("请输入要借出单车的序号:");
        int inputBid = sc.nextInt();
        String rentName = "";
        boolean b = false;
        for (SharedBike sharedBike : sharedBikes) {
            if (sharedBike.getBid() == inputBid) {
                if (sharedBike.getStatus() == 1) {
                    sharedBike.setBorrowTime(new Date());
                    sharedBike.setStatus(0);
                    rentName = sharedBike.getBname();
                    b = true;
                }
            }
        }
        if (b) {
            prt("借出" + companies[rentInput].getBikeCompanyName() + "下的" + rentName + "成功");
        } else {
            prt("借出失败");
        }
        companies[rentInput].setSharedBikes(sharedBikes);
        return companies;
    }

    //归还
    @Override
    public SharedBikeCompany[] backBikes(SharedBikeCompany[] companies) {
        prt("------>5.归还bike");
        showTitles();
        int rentInput = sc.nextInt() - 1;
        prt("此" + companies[rentInput].getBikeCompanyName() + "单车下有共享单车如下:");
        SharedBike[] sharedBikes = companies[rentInput].getSharedBikes();
        prt("单车序号\t单车名称\t单车状态\t借出时间\t归还时间");
        for (SharedBike bike : sharedBikes) {
            showBikes(bike);
        }
        prt("请输入要归还单车的序号:");
        int inputBid = sc.nextInt();
        //归还车的名字
        String backName = "";
        //借出时长
        double i1 = 0;
        //借出的时间
        String borrowTime = "";
        //归还时间
        Date backTime = new Date();
        boolean b = false;
        for (SharedBike sharedBike : sharedBikes) {
            if (sharedBike.getBid() == inputBid && sharedBike.getStatus() == 0) {
                sharedBike.setBackTime(backTime);
                sharedBike.setStatus(1);
                backName = sharedBike.getBname();
                b = true;
                borrowTime = sd.format(sharedBike.getBorrowTime());
                i1 = DateUtils.getMinus(sharedBike.getBackTime(), sharedBike.getBorrowTime());

            }
        }
        if (b) {
            prt("归还" + companies[rentInput].getBikeCompanyName() + "下的" + backName + "成功");
            companies[rentInput].setCount(companies[rentInput].getCount() + 1);
            prt("您的借车时间为" + borrowTime);
            prt("您用时为:" + (long) i1 + "小时" + "需要支付" + ((int) i1 + 1) + "元");
        } else {
            prt("归还 失败");
        }
        companies[rentInput].setSharedBikes(sharedBikes);
        return companies;
    }

    //排行
    @Override
    public void sortBikes(SharedBikeCompany[] companies) {
        //冒泡
        for (int i = 0; i < companies.length - 1; i++) {
            for (int j = 0; j < companies.length - 1 - i - 1; j++) {
                if (companies[j].getCount() > companies[j + 1].getCount()) {
                    SharedBikeCompany sharedBikeCompany = companies[j];
                    companies[j] = companies[j + 1];
                    companies[j + 1] = sharedBikeCompany;
                }
            }
        }
        prt("公司名称" + "\t借车次数");
        for (SharedBikeCompany company : companies) {
            prt(company.getBikeCompanyName() + "\t\t" + company.getCount());

        }
    }

    //重复的展示
    private void showTitles() {
        prt("1." + COMPANY_NAME_OFO);
        prt("2." + COMPANY_NAME_HALO);
        prt("3." + COMPANY_NAME_MOBIKE);
        prt("请选择要操作的单车品牌:");
    }

    //单车的显示
    public void showBikes(SharedBike bike) {
        prt(bike.getBid() + "\t\t" + bike.getBname() + "\t\t" + BikeUtils.getBikeState(bike.getStatus())
                + "\t\t" + DateUtils.dateFormat(bike.getBorrowTime()) + "\t\t" + DateUtils.dateFormat(bike.getBackTime()));
    }

}