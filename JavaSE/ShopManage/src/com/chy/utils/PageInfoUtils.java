package com.chy.utils;

import com.chy.bean.PageInfo;

import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/21-15:42
 * @Since:jdk1.8
 * @Description:TODO
 */

public class PageInfoUtils {

    /**
     * 分页显示的下一页
     *
     * @param i
     * @param pageInfo
     * @return
     */
    public static int pageForNextPage(int i, PageInfo pageInfo) {
        System.out.println("1：上一页 2：下一页 3、选择页数！ 0,退出 ");
        int inputPage = new Scanner(System.in).nextInt();
        switch (inputPage) {
            case 1:
                if (i == 0) {
                    System.out.println("这已经第一页！");
                } else {
                    i--;
                }
                break;
            case 2:
                if (i == pageInfo.getAllPage() - 1) {
                    System.out.println("这已经最后一页！");
                } else {
                    i++;
                }
                break;
            case 3:
                System.out.println("请输入你要调到的页数：");
                inputPage = new Scanner(System.in).nextInt();
                //如果输入的小于0，直接显示第一页
                if (inputPage < 0) {
                    i = 0;
                } else if (inputPage >= pageInfo.getAllPage()) {
                    //如果输入的是大于总页数，直接显示最后一页
                    i = inputPage - 1;
                } else {
                    i = inputPage - 1;
                }
                break;
            case 0:
               i = -1;
                break;
            default:
                break;
        }
        return  i;
    }

}