package com.chy.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVO {
    //成绩编号 自动递增
    private Integer id;
    //学生编号
    private Integer stuId;
    //学生院系
    private String department;
    //科目
    private String cName;
    //成绩
    private Integer grade;
}