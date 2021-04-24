package com.homeWork.bean;

import lombok.Data;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-21:36
 * @Since:jdk1.8
 * @Description:
 */
@Data
public class PageInfo {
    //总数
    private Integer allCount;

    //每一页的条数
    private Integer count = 5;

    //总页数
    private Integer allPage;

    //当前页数
    private Integer page;

    //初始化除了总数外的所有数据  先设置每一页的固定条数
    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
        this.allPage = (allCount % count != 0) ? (allCount / count) + 1 : (allCount/count);
    }
}