package com.chy.utils;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-19:05
 * @Since:jdk1.8
 * @Description: 
 */
public class BikeUtils {

    /**
     * 根据状态的编号获取对应的状态名称
     *
     * @param state
     * @return
     */
    public static String getBikeState(int state)   throws  NullPointerException{
        String result = null;
        if (state == 0) {
            result = "已借出";
        } else {
            result = "可借";
        }
        return result;
    }
}