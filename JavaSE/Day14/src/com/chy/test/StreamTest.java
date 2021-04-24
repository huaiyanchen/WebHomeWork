package com.chy.test;

import com.chy.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-19:23
 * @Since:jdk1.8
 * @Description: 
 */
public class StreamTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User(12, "chy");
        list.add(user);
        list.add(new User(123, "123"));
        list.add(new User(124, "124"));
        list.add(new User(125, "125"));
        list.add(new User(126, "126"));


        System.out.println("11111111111111111111111111111111111111111111111");
        List<User> collect = list.stream().filter(c -> c.getAge() != 12).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("222222222222222222222222222222222222222");
        Map<Integer, User> collectMapUser = list.stream().collect(Collectors.toMap(User::getAge, Function.identity()));
        collectMapUser.forEach((k, v) -> System.out.println(k + "    " + v));
    }
}