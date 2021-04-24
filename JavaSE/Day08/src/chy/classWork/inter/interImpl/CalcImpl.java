package chy.classWork.inter.interImpl;

import chy.classWork.inter.Calc;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-15:02
 * @Since:jdk1.8
 * @Description: 
 */
public class CalcImpl implements Calc {

    @Override
    public float sum(float f1, float f2) {
        return f1 + f2;
    }
}