package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-19:44
 * @Since:jdk1.8
 * @Description:
 */
@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private static int count;

    public Person() {
    }

    public Person(int id, String name, int age) {
        count++;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void compareAge(Person person) {
        if (this.age < person.getAge()) {
            System.out.println(this.name + "年纪小一点");
        }
        if (this.age == person.getAge()) {
            System.out.println(this.name + "和" + person.getName() + "年纪一样大");
        }
        if (this.age > person.getAge()) {
            System.out.println(this.name + "年纪大一点");
        }
    }

    public int times() {
        return count;
    }
}