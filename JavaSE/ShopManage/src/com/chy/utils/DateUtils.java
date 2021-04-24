package com.chy.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-19:57
 * @Since:jdk1.8
 * @Description:TODO
 */

public class DateUtils {
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间
     * @return
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 时间输出格式化
     * @param date
     * @return
     */
    public static String dataFormate(Date date) {
        return format.format(date);
    }

    /**
     * 获取当天的八点时间
     * @return
     */
    public static LocalDateTime getEight() {
        LocalDateTime toDay = LocalDateTime.now();
        LocalDateTime startDateTime = LocalDateTime.of(toDay.toLocalDate(), LocalTime.MIN.withHour(8));
        return startDateTime;
    }

    /**
     * @param date
     * @return 和每天的八点时间比较
     *  比八点大 的返回 1 true
     */
    public static boolean isBigByEight(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        int i = localDateTime.compareTo(getEight());
        return i == 1;
    }

}