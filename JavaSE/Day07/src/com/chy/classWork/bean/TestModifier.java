package com.chy.classWork.bean;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-15:55
 * @Since:jdk1.8
 * @Description:
 */
public class TestModifier {
    public int publi;//父 全包,全类都能用 ,子 不同包能使用,
    int size;///父 全包,全类都能用   子 同一个包可以使用,不同包不能使用
    protected String pro;//
    private String privat;//当前类使用
}