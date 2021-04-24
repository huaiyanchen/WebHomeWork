package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:34
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private String name;
    private int time;
    private String singer;
}