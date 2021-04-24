package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/3-17:39
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Cloneable {

    public String name;
    public int age;
    public Integer number;
    public int[] wi;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("chy", 12, 12, new int[]{1, 2});
        User user2 = (User) user.clone();

        System.out.println(user == user2);

        System.out.println(user.number == user2.number);

        System.out.println(user.getNumber() == user2.getNumber());

        System.out.println(user.wi == user2.wi);
    }
}