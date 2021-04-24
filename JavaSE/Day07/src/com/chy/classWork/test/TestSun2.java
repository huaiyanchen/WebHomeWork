package com.chy.classWork.test;

import com.chy.classWork.bean.TestModifier;


/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-15:59
 * @Since:jdk1.8
 * @Description:
 */
public class TestSun2 extends TestModifier {


    public static void main(String[] args) {
        TestModifier testModifier = new TestModifier();
        testModifier.publi = 12;

        TestSun2 testSun2 = new TestSun2();
        testSun2.pro = "123";//protected
        testSun2.publi = 12;

    }
}