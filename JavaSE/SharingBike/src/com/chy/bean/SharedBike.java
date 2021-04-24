package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/1-11:20
 * @Since:jdk1.8
 * @Description:SharedBike
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SharedBike {
    private int bid;// 单车编号
    private String bname;// 单车名称-->ofo 哈罗 摩拜
    private int status;// 单车状态--> 0 已借出 1 可借状态
    private Date borrowTime;// 单车借出时间
    private Date backTime;// 单车时间
}