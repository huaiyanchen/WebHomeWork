package com.chy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-11:50
 * @Since:jdk1.8
 * @Description: 
 */
public class DateUtils {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    //获取当前系统时间
    public static Date getNow() {
        return new Date();
    }

    //Date --> String
    public static String dateFormat(Date date) {
        String result = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
            result=sdf.format(date);

        }
        return result;
    }

    //获取两个日期之间的时间差（天）
    public static int getDayByDate(Date date1, Date date2) {
        int day = 0;
        day = (int) ((date2.getTime() - date1.getTime()) / (1000L * 60 * 60 * 24));
        return  day;
    }

    //String --> Date
    public static Date stringParse(String time) {
        Date date = null;
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
            try {
                date=sdf.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

}