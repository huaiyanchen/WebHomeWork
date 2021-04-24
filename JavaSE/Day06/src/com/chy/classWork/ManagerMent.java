package com.chy.classWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-18:03
 * @Since:jdk1.8
 * @Description: 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerMent {
    private int id;
    private String name;
    private String gender;
    private int salary;
    private String exp;
    private String bonus;

    public int salary() {
        return salary+Integer.parseInt(bonus);
    }


    public void  show() {
        System.out.println("ManagerMent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", exp='" + exp + '\'' +
                ", bonus='" + bonus + '\'' +
                '}');
    }
}