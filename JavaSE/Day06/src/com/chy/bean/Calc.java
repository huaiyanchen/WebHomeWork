package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-19:51
 * @Since:jdk1.8
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calc {
    private double num1;
    private double num2;
    private String operator;

    public String calc() {
        String result;
        switch (operator) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    result = "除数不能为零";
                } else {
                    result = String.valueOf(num1 / num2);
                }
                break;
            default:
                result = "暂无该运算";
                break;
        }
        return result;
    }

}