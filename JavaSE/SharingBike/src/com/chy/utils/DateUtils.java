package com.chy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/2-10:28
 * @Since:jdk1.8
 * @Description: 
 */
public class DateUtils {

    //时间格式化输出格式
    public static String dateFormat(Date date) {
        String result = "null";
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result = simpleDateFormat.format(date);
        }
        return result;
    }

    public static double getMinus(Date date1, Date date2) {
        //date1>date2
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        System.out.println("( date1.getTime() - date2.getTime()) = " + (date1.getTime() - date2.getTime()));
        double time = (date1.getTime() - date2.getTime()) / (60.0 * 60.0 * 1000.0);
        System.out.println("time = " + time);
        return time;
    }


}