package chy.homeWork.Num3.inter;

import chy.homeWork.Num3.bean.Student;
import chy.homeWork.Num3.bean.Subject;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/31-19:53
 * @Since:jdk1.8
 * @Description:
 */
public interface ScoreSearch {

    //根据某个学生的名称，查找对应的成绩有
    public Subject[] scoreSearchByName(Student student);

    //根据某个学生的名称，计算及格的成绩有几门？并且计算出该学生的总分数
    public void calcScore(Student student);

    //显示
    public void showAll();

}