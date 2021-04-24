package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-17:52
 * @Since:jdk1.8
 * @Description:  cpu，网卡，显卡，声卡，内存 方法：上网
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    private String cpu;
    private String networkCard;
    private String graphicsCard;
    private String soundCard;
    private String ram;

    public void goOnline() {
        System.out.println("Can go online");

    }
}