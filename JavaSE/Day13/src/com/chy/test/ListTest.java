package com.chy.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-15:10
 * @Since:jdk1.8
 * @Description: 
 */
@SuppressWarnings("all")
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        List lis = new LinkedList();
        list.add("qwe");
        list.add("asd");
        list.add("zxc");
        list.add("1");
        list.add("098");

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println("list.size() = " + list.size());

        System.out.println("list.get(1) = " + list.get(1));

        System.out.println("list.indexOf(\"qwe\") = " + list.indexOf("qwe"));

        System.out.println("list.isEmpty() = " + list.isEmpty());

        System.out.println("list.set(1, \"chy\") = " + list.set(1, "chy"));

        System.out.println("list " + list);

        System.out.println("list.subList(1, 3) = " + list.subList(1, 3));

        list.forEach(e -> {
            System.out.println("e = " + e);
        });
    }
}