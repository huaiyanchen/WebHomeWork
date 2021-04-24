package com.chy.test.homwWork.Num3;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-20:15
 * @Since:jdk1.8
 * @Description:
 */

public class User {
    //姓名
    private String name;
    //票数
    private Integer num;

    public User() {
    }

    public User(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}