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
public class BWPrint extends Print {
    //商品产地
    private String addr;

    @Override
    public void print() {
        System.out.println(super.getName() + "can" + "单面打印");

    }

    @Override
    public void scan() {
        System.out.println(super.getName() +"扫描的行为");
    }
}