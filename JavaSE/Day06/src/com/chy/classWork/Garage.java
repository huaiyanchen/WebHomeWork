package com.chy.classWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-17:36
 * @Since:jdk1.8
 * @Description:
 */
/*
	Java描述修车厂，修车厂具备，名字、地址、电话三个属性，具备修车的功能行为，
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {
    private String name;
    private String addr;
    private String phone;

    private Car car;

    public void fix() {
        System.out.println(car+"should be fixed!!!");
    }
}