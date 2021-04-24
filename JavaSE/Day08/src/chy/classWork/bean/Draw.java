package chy.classWork.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-11:36
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Draw {
    //x
    private String xAxle;
    //y
    private String yAxle;
    //颜色
    private String color;

    //绘制
    public abstract void print();
}