package com.chy.test.com.chy.homeWork.Num5;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-20:26
 * @Since:jdk1.8
 * @Description:
 */

public class User {
    Integer id;
    String name;
    String sex;

    public User() {
    }

    public User(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}