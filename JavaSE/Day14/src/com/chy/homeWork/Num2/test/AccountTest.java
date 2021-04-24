package com.chy.homeWork.Num2.test;

import com.chy.homeWork.Num2.bean.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/8-20:45
 * @Since:jdk1.8
 * @Description: 
 */
public class AccountTest {
    public static void main(String[] args) {
        ArrayList<Account> list = new ArrayList();
        list.add(new Account(10.00,"1234"));
        list.add(new Account(15.00, "5678"));
        list.add(new Account(0, "1010"));

        Map<Integer, Account> accountMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            accountMap.put(i, list.get(i));
        }

        accountMap.forEach((k,v)-> System.out.println("id:"+k+"\t余额:"+v.getBalance()));
    }

}