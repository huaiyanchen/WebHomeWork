package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-19:40
 * @Since:jdk1.8
 * @Description: 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
//长方形
public class Rectangle {
    private int length;
    private int width;

    public int area() {
        return length * width;
    }

    public int periMeter() {
        return (length + width) * 2;
    }
}