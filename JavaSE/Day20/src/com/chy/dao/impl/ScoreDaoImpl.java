package com.chy.dao.impl;

import com.chy.bean.Score;
import com.chy.bean.Student;
import com.chy.dao.ScoreDao;
import com.chy.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-14:58
 * @Since:jdk1.8
 * @Description:
 */

public class ScoreDaoImpl implements ScoreDao {
    private Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public boolean add(Score score) {
        String sql = "insert into  score values(null,?,?,?)";
        return DBUtils.executeUpdate(sql,score.getStudent().getId(),score.getCName(),score.getId());
    }

    @Override
    public List<Score> findAllStu() {
        List<Score> scoreList = new ArrayList<>();
        String sql = "select s1.stuName,s2.* from student s1,score s2 where s1.id = s2.stu_id";
            try {
                resultSet = DBUtils.executeQuery(sql);
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setStuName(resultSet.getString("stuName"));
                    student.setId(resultSet.getInt("id"));

                    Score score = new Score(resultSet.getInt("stu_id"), student,
                            resultSet.getString("c_name"),
                            resultSet.getInt("grade"));
                    scoreList.add(score);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return scoreList;
    }

}