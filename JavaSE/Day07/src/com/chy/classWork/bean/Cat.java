package com.chy.classWork.bean;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-15:18
 * @Since:jdk1.8
 * @Description:
 */


public class Cat extends Animal {
    private int size;
    // 当父类手写了有参构造函数，Java就不会赠送无参构造函数，所以子类继承的时候，也只能继承父类的有参构造函数。
    public Cat(String name, String age, int size) {
        super(name, age);
        this.size = size;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println(getName()+"eat eat");
    }
}