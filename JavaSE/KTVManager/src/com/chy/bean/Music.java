package com.chy.bean;

import lombok.*;
import com.chy.util.ChineseCharacterUtil;

import java.util.Date;

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
@ToString
public class Music {
    //编号
    private Integer id;
    //歌曲名
    private String name;
    //简拼
    private String jpName;
    //全拼
    private String qpName;
    //歌手
    private String author;
    //所属类别
    private MusicType musicType;
    //时长
    private String musicLength;
    //上架时间
    private Date upTime;
    //点歌次数
    private Integer count;

    public Music(Integer id, String name, String author, MusicType musicType, String musicLength, Date upTime, Integer count) {
        this.id = id;
        this.name = name;
        this.jpName = ChineseCharacterUtil.getLowerCase(name, false);
        this.qpName = ChineseCharacterUtil.getLowerCase(name, true);
        this.author = author;
        this.musicType = musicType;
        this.musicLength = musicLength;
        this.upTime = upTime;
        this.count = count;
    }
}
