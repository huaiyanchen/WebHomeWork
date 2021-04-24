package chy.classWork.inter;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-15:39
 * @Since:jdk1.8
 * @Description: 
 */
public interface ArrayManager {
    /*
         显示数组的内容！
        */
    void showArray(int[] nums);


    /**
     * 添加数据
     * @param nums
     * @param scanner
     * @return
     */
    int[] addNums(int [] nums, Scanner scanner);

    /**
     * 求出数组中偶数的个数，并且返回偶数的数组！
     * @param nums
     * @return  偶数的数组
     */
    int []  getEvenNums(int [] nums);

    /**
     * 数组排序
     * @param nums
     */
    void sortArray(int [] nums);

    /**
     * 求出数组的数据之和！
     * @param nums
     * @return  数组的数据之和
     */
    int getArraySum(int [] nums);
}