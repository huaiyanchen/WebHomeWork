package chy.classWork.test;

import chy.classWork.bean.Circle;
import chy.classWork.bean.Draw;
import chy.classWork.bean.Line;
import chy.classWork.bean.Rectangle;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-11:44
 * @Since:jdk1.8
 * @Description:
 */
public class DrawTest {
    public static void main(String[] args) {
        Draw circle = new Circle("2");
        Draw line = new Line("2","3");
        Draw rectangle = new Rectangle("2", "3");
        Draw[] draws = new Draw[]{circle, line, rectangle};
        for (Draw draw : draws) {
            draw.print();
            System.out.println();
        }
    }
}