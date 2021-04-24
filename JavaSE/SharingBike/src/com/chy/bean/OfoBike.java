package com.chy.bean;

import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-15:56
 * @Since:jdk1.8
 * @Description:OfoBike
 */
public class OfoBike extends SharedBike {
    public OfoBike(Integer bid, String bname, Integer status, Date borrowTime, Date backTime) {
        super(bid, bname, status, borrowTime, backTime);
    }
}