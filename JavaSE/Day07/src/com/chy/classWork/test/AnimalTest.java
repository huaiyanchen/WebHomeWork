package com.chy.classWork.test;

import com.chy.classWork.bean.Cat;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-15:17
 * @Since:jdk1.8
 * @Description:
 */
public class AnimalTest {
    public static void main(String[] args) {
        Cat cat = new Cat("123","123",123);
        cat.setName("321");

        cat.eat();
    }
}