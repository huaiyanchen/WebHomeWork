package com.chy.service;

import com.chy.bean.SharedBikeCompany;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-11:28
 * @Since:jdk1.8
 * @Description: 
 */

public interface BikeManager {

    //1.投放
    SharedBikeCompany[] addBikes(SharedBikeCompany[] companies);

    //2.查看bikes
    void showBikes(SharedBikeCompany[] companies);

    //3.删除bikes
    SharedBikeCompany[] deleteBikes(SharedBikeCompany[] companies);

    //4.借出bike
    SharedBikeCompany[] rentBikes(SharedBikeCompany[] companies);

    //5.归还bike
    SharedBikeCompany[] backBikes(SharedBikeCompany[] companies) ;

    //6.Bike排行榜
    void sortBikes(SharedBikeCompany[] companies);

}