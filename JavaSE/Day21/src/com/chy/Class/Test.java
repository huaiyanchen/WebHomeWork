package com.chy.Class;

import com.chy.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-15:18
 * @Since:jdk1.8
 * @Description: reflect
 */

public class Test {
    public  void getProperties() {
        User user = new User();
        Class<? extends User> aClass = user.getClass();

        //私有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        //public 属性
        Field[] fields = aClass.getFields();
        System.out.println(Arrays.toString(fields));

        // 获取类里面的所有方法
        Method[] methods = aClass.getMethods();
        System.out.println("methods = " + Arrays.toString(methods));

        // 排除了object的公共方法   可以获取公共的和私有的  declaredMethods
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("declaredMethods = " + Arrays.toString(declaredMethods));

        // 所有的构造方法
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("constructors = " + Arrays.toString(constructors));

    }

    public void setProperties() throws Exception {

        Class<?> aClass = Class.forName("com.chy.bean.User");

        User user = (User) aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "chy");
        Object o = name.get(user);
        System.out.println("o = " + o);
    }

    public void  setValue() throws Exception {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Method setId = userClass.getMethod("setId", Integer.class);
        Object invoke = setId.invoke(user, 100); // user.setId(100)

        Method getId = userClass.getMethod("getId");
        Object invoke1 = getId.invoke(user);
        System.out.println("invoke1 = " + invoke1);
        System.out.println(user);

    }



    public static void main(String[] args) throws Exception {
        new Test().setProperties();

    }
}