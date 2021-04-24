package chy.homeWork.Num2.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-19:02
 * @Since:jdk1.8
 * @Description: 
 */
@Data
@NoArgsConstructor

public class Teacher extends Person {

    public Teacher(String name, String id, String pwd) {
        super(name, id, pwd);
    }
}