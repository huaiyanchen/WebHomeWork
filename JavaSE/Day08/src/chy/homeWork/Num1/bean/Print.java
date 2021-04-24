package chy.homeWork.Num1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:20
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Print {
    //名称
    private String name;
    //编号
    private int id;

    //打印
    public void print() {
        System.out.println("It can print");
    }

    public abstract void scan();


}