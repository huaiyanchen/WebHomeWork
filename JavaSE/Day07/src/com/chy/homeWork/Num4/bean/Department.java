package com.chy.homeWork.Num4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:54
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Manager manager;

    private GeneralStuff[] generalStuffs;
    

}