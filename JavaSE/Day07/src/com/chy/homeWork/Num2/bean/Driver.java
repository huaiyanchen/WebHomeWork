package com.chy.homeWork.Num2.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-18:57
 * @Since:jdk1.8
 * @Description:
 */
@Data

@NoArgsConstructor
public class Driver {

    public void drive(Car car) {
        if (car instanceof BMW) {
            BMW bmw = (BMW) car;
            bmw.run(bmw);
        }
        if (car instanceof BenZ) {
            BenZ benZ = (BenZ) car;
            benZ.run(benZ);
        }
    }

}