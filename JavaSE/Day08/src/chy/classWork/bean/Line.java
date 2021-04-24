package chy.classWork.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-11:38
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line extends Draw {
    private String xPoint;
    private String yPoint;

    @Override
    public void print() {
        System.out.println(toString());
        System.out.println("绘制了线条");
    }
}