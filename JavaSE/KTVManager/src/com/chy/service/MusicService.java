package com.chy.service;

import com.chy.bean.Music;

import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/9-15:45
 * @Since:jdk1.8
 * @Description:
 */
public interface MusicService {

    /**
     * @author: chy
     * @Date: 2021/4/9 15:55
     * @Description: 按拼音点歌
     */
    Music callSongBySpell(List<Music> musicList);


    /**
     * @author: chy
     * @Date: 2021/4/9 15:55
     * @Description: 按歌曲名点歌
     */
    Music callSongByName(List<Music> musicList);


    /**
     * @author: chy
     * @Date: 2021/4/9 15:55
     * @Description: 按歌星
     */
    Music callSongBySinger(List<Music> musicList);


    /**
     * @author: chy
     * @Date: 2021/4/9 16:03
     * @Description: 按分类点歌
     */
    Music callSongByType(List<Music> musicList);

    /**
     * @author: chy
     * @Date: 2021/4/9 16:03
     * @Description: 好歌排行榜
     */
    Music callSongByRant(List<Music> musicList);

    /**
     * @author: chy
     * @Date: 2021/4/9 19:10
     * @Description: 前置歌曲
     */
    void preSong(List<Music> musics);

    /**
     * @author: chy
     * @Date: 2021/4/9 19:10
     * @Description: 删除
     */
    void deleteSong(List<Music> musics);

    /**
     * @author: chy
     * @Date: 2021/4/9 19:10
     * @Description: 前移一位
     */
    void forwardSong(List<Music> musics);

}