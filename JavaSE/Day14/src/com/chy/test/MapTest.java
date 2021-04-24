package com.chy.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-16:10
 * @Since:jdk1.8
 * @Description:
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Object> maps = new HashMap<>();

        maps.put("年纪", 12);
        maps.put("序号", 41234);
        maps.put("姓名", "chy");
        maps.put("成绩", 90);
        maps.put("性别", "男");

        System.out.println("---------------------------------");
        Set<String> strings = maps.keySet();
        strings.forEach(s -> System.out.println(maps.get(s)));
        System.out.println("---------------------------------");
        maps.forEach((k, v) -> System.out.println(k + v));
        System.out.println("---------------------------------");
        Set<Map.Entry<String, Object>> entries = maps.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("---------------------------------");
        System.out.println(entries);
        System.out.println("---------------------------------");
        System.out.println(maps);
    }
}