package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-15:10
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankUser {
    public String userNo;
    public String userPwd;
    public float userMoney;
    public String date;

}