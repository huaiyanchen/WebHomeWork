package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-10:58
 * @Since:jdk1.8
 * @Description:SharedBikeCompany
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharedBikeCompany {
    private int bikeCompanyId;// 公司id
    private String bikeCompanyName;// ofo 哈罗 摩拜
    private SharedBike[] sharedBikes;// 公司持有共享单车
    private int sum;//公司单车总量
    private int count;// 公司单车借出次数
}