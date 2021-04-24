package com.chy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:34
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Play {
    private String name;
    private int time;

    private Music music;

    public void song() {
        int lastTime =music.getTime() - time;
        System.out.println(music.getSinger() + "歌唱的音乐" + music.getName() + "剩余时间" + lastTime + "分钟");
    }
}