package chy.classWork.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-11:41
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
public class Rectangle extends Draw {
    //长
    private String length;
    //宽
    private String width;

    @Override
    public void print() {
        System.out.println(toString());
        System.out.println("绘制了矩形");
    }
}