package com.chy.classWork.bean;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-15:56
 * @Since:jdk1.8
 * @Description: 
 */
public class TestSun extends TestModifier {

    public static void main(String[] args) {
        TestModifier testModifier = new TestModifier();
        testModifier.pro = "123";
        testModifier.publi = 12;
        testModifier.size = 12;

        TestSun testSun = new TestSun();
        testSun.pro = "123";
        testSun.publi = 12;
        testSun.size = 12;
    }
}