package com.homeWork.utils;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-17:06
 * @Since:jdk1.8
 * @Description:TODO
 */

public class ClassUtils {
    public static String classStringCast(String columnLabel) {

        StringBuilder stringBuilder = new StringBuilder("set");
        stringBuilder.append(columnLabel.substring(0,1).toUpperCase());
        stringBuilder.append(columnLabel.substring(1,columnLabel.length()));
        if (stringBuilder.toString().contains("_")) {

        }
        return stringBuilder.toString();
    }

    public static Class classCast(String columnTypeName) {
        Class<?> aClass = null;
        try {
            //两种特殊的时间类
            if("java.sql.Timestamp".equals(columnTypeName)){
                columnTypeName = "java.util.Date";
            }
            if("java.sql.Date".equals(columnTypeName)){
                columnTypeName = "java.util.Date";
            }
            aClass =Class.forName(columnTypeName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }
}