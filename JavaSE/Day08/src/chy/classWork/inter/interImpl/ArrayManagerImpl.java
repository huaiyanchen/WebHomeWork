package chy.classWork.inter.interImpl;

import chy.classWork.inter.ArrayManager;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-15:40
 * @Since:jdk1.8
 * @Description: 
 */
public class ArrayManagerImpl implements ArrayManager {
    @Override
    public void showArray(int[] nums) {
        System.out.println("数组的内容如下：");
        System.out.println(Arrays.toString(nums));
    }

    @Override
    public int[] addNums(int[] nums, Scanner scanner) {
        System.out.println("请输入数字：");
        int inputNum = scanner.nextInt();
        //获取原数组的长度
        int oldLength = nums.length;
        //扩容

        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = inputNum;
        int newLength = nums.length;
        //长度  ： 原数组的长度  和 扩容之后的长度
        if (newLength > oldLength) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
        return nums;
    }

    @Override
    public int[] getEvenNums(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                cur++;
            }
        }
        int[] evenNums = new int[cur];
        int evenCur = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenNums[evenCur++] = num;
            }
        }
        return evenNums;
    }

    @Override
    public void sortArray(int[] nums) {
        Arrays.sort(nums);
    }

    @Override
    public int getArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}