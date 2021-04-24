package com.chy.homeWork.Num3.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-20:58
 * @Since:jdk1.8
 * @Description:
 */
public class Num3Test {
    static List<String> stringList = new ArrayList<>();

    public void init() {
        stringList.add("科特迪瓦");
        stringList.add("阿根廷");
        stringList.add("澳大利亚");
        stringList.add("塞尔维亚");
        stringList.add("荷兰");
        stringList.add("尼日利亚");
        stringList.add("日本");
        stringList.add("美国");
        stringList.add("中国");
        stringList.add("新西兰");
        stringList.add("巴西");
        stringList.add("比利时");
        stringList.add("韩国");
        stringList.add("喀麦隆");
        stringList.add("洪都拉斯");
        stringList.add("意大利");
    }

    public static void main(String[] args) {
        Num3Test num3Test = new Num3Test();
        num3Test.init();
        HashMap<Integer, List<String>> stringHashMap = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                String s = stringList.get(new Random().nextInt(stringList.size()));
                list.add(s);
                stringList.remove(s);
            }
            stringHashMap.put(i, list);
        }

        stringHashMap.forEach((k, v) -> {
            System.out.println("第" + k + "组有:");
            for (String s : v) {
                System.out.print(s + "\t\t\t");
            }
            System.out.println();
        });
    }
}