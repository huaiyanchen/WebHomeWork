package com.chy.test;

import com.chy.bean.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-19:47
 * @Since:jdk1.8
 * @Description: 
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(1, "yhc", 23);
        Person p2 = new Person(2, "chy", 24);
        p1.compareAge(p2);
        System.out.println("times() = " + p1.times());
    }
}