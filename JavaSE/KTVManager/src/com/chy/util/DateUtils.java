package com.chy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/9-14:47
 * @Since:jdk1.8
 * @Description:
 */
public class DateUtils {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取系统时间
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     *  @author: chy
     *  @Date: 2021/4/9 20:14
     *  @Description: 时间格式化
     */
    public static String showDate(Date date) {
        return sdf.format(date);
    }
}
