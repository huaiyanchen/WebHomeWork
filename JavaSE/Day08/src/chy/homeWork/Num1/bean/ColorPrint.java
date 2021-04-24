package chy.homeWork.Num1.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:22
 * @Since:jdk1.8
 * @Description: 
 */
@Data
public class ColorPrint extends Print {
    //技术类型
    private String skillType;

    @Override
    public void print() {
        System.out.println("双面打印");
    }

    @Override
    public void scan() {
        System.out.println(super.getName()+"扫描的行为");
    }
}