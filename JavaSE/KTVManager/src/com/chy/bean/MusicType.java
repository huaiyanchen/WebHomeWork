package com.chy.bean;

import lombok.*;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/9-14:47
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicType {
    //类别编号
    private Integer typeId;
    //类别名称
    private String typeName;
}
