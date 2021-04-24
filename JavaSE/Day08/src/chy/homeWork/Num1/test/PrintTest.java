package chy.homeWork.Num1.test;


import chy.homeWork.Num1.bean.BWPrint;
import chy.homeWork.Num1.bean.ColorPrint;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/30-19:25
 * @Since:jdk1.8
 * @Description: 
 */
public class PrintTest {

    public static void main(String[] args) {
        ColorPrint colorPrint = new ColorPrint();
        colorPrint.setSkillType("1");
        colorPrint.setName("color");
        colorPrint.setId(1);
        colorPrint.scan();

        BWPrint bwPrint = new BWPrint();
        bwPrint.setAddr("USA");
        bwPrint.setName("BW");
        bwPrint.setId(1);
        bwPrint.scan();

    }
}