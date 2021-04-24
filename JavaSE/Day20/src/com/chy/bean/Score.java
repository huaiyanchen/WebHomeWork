package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * score
 * @author chy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score implements Serializable {
    private static final long serialVersionUID = 3134542552199980086L;
    //成绩编号 自动递增
    private Integer id;
    //学生
    private Student student;
    //科目
    private String cName;
    //成绩
    private Integer grade;

}