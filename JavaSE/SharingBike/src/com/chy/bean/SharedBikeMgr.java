package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.chy.constants.BikeConstants.*;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-11:31
 * @Since:jdk1.8
 * @Description:SharedBikeMgr
 */

@Data
@AllArgsConstructor
public class SharedBikeMgr {

    private SharedBikeCompany[] sharedBikeCompanies;

    public SharedBikeMgr() {

    }

    //数据初始化
    public SharedBikeCompany[] init() {
        sharedBikeCompanies = new SharedBikeCompany[3];
        //第一家公司   ofo
        SharedBikeCompany ofoCompany = new SharedBikeCompany(1, COMPANY_NAME_OFO, null, 3, 200);
        SharedBike[] ofoBikes = new SharedBike[ofoCompany.getSum()];
        for (int i = 0; i < ofoBikes.length; i++) {
            OfoBike bike = new OfoBike(100 + i, "ofo" + i, 1, null, null);
            ofoBikes[i] = bike;
        }
        ofoCompany.setSharedBikes(ofoBikes);

        //第二家公司   halo
        SharedBikeCompany haloCompany = new SharedBikeCompany(2, COMPANY_NAME_HALO, null, 4, 100);
        SharedBike[] haloBikes = new SharedBike[haloCompany.getSum()];
        for (int i = 0; i < haloBikes.length; i++) {
            HaloBike bike = new HaloBike(200 + i, "Halo" + i, 1, null, null);
            haloBikes[i] = bike;
        }
        haloCompany.setSharedBikes(haloBikes);

        //第三家公司   moBike
        SharedBikeCompany moBikeCompany = new SharedBikeCompany(3, COMPANY_NAME_MOBIKE, null, 3, 300);
        SharedBike[] moBikeBikes = new SharedBike[moBikeCompany.getSum()];
        for (int i = 0; i < moBikeBikes.length; i++) {
            MoBaiBike bike = new MoBaiBike(300 + i, "MoBai" + i, 1, null, null);
            moBikeBikes[i] = bike;
        }
        moBikeCompany.setSharedBikes(moBikeBikes);
        sharedBikeCompanies[0] = ofoCompany;
        sharedBikeCompanies[1] = haloCompany;
        sharedBikeCompanies[2] = moBikeCompany;
        return sharedBikeCompanies;
    }
}