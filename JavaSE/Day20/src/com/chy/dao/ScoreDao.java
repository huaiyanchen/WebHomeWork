package com.chy.dao;

import com.chy.bean.Score;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-10:28
 * @Since:jdk1.8
 * @Description:
 */
public interface ScoreDao {
    /**
     * @author: chy
     * @Date: 2021/4/19 10:46
     * @Description: 添加学生信息
     */
    boolean add(Score score);


    /**
     * 查询所有信息
     *
     * @return
     */
    List<Score> findAllStu();
}