package chy.homeWork.Num2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-19:00
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    //姓名
    private String name;
    //账号
    private String id;
    //密码
    private String pwd;
}