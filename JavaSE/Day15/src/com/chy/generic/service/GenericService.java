package com.chy.generic.service;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/9-11:53
 * @Since:jdk1.8
 * @Description: 
 */
public interface GenericService<T> {

    void show(T[] ts);
}