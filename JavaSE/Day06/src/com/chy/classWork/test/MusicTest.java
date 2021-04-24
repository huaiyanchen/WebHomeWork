package com.chy.classWork.test;

import com.chy.classWork.Music;
import com.chy.classWork.Play;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/29-20:35
 * @Since:jdk1.8
 * @Description:
 */
public class MusicTest {
    public static void main(String[] args) {
        Music music = new Music("富士山下",5,"Eason");
        Play play = new Play();
        play.setTime(3);
        play.setName("chy");
        play.setMusic(music);
        play.song();
    }
}