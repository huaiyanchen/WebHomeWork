package com.chy.bean;

import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-15:17
 * @Since:jdk1.8
 * @Description:
 */
public class User {
    //序号
    private Integer id;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //身份证号
    private String idCardNumber;

    //联系方式
    private String tel;

    //家庭住址
    private String address;

    //注册时间
    private Date loginTime;

    public String test;
    private void test() {
        System.out.println("tt");

    }

    public User() {
    }

    public User(Integer id, String name, Integer age, String idCardNumber, String tel, String address, Date loginTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.idCardNumber = idCardNumber;
        this.tel = tel;
        this.address = address;
        this.loginTime = loginTime;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard_number() {
        return idCardNumber;
    }

    public void setIdCard_number(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLogin_time() {
        return loginTime;
    }

    public void setLogin_time(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}