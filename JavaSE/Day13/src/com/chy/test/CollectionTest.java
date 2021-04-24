package com.chy.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/7-11:53
 * @Since:jdk1.8
 * @Description: 
 */
public class CollectionTest {
    public static void showCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1);
        showCollection(collection);

    }
}