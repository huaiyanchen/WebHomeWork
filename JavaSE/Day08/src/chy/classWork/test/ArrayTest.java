package chy.classWork.test;

import chy.classWork.inter.ArrayManager;
import chy.classWork.inter.interImpl.ArrayManagerImpl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-15:47
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayTest {
    private Scanner scanner;
    private int[] nums;
    private ArrayManager arrayManager = new ArrayManagerImpl();

    public ArrayTest() {
        scanner = new Scanner(System.in);
        nums = new int[]{20, 30, 1, 15, 41, 25};
    }

    /**
     * 菜单
     */
    public void menu() {
        while (true) {
            System.out.println("1、添加数组  2、显示数组 3、排序 4、找偶数");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    nums = arrayManager.addNums(nums, scanner);
                    break;
                case 2:
                    arrayManager.showArray(nums);
                    break;
                case 3:
                    arrayManager.sortArray(nums);
                    break;
                case 4:
                    int[] evenNums = arrayManager.getEvenNums(nums);
                    System.out.println("偶数的内容有：" + Arrays.toString(evenNums));
                    break;
                default:
                    break;
            }
        }


    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.menu();
    }
}