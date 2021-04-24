package com.chy.test;

import com.chy.bean.Music;
import com.chy.bean.MusicType;
import com.chy.service.Impl.MusicServiceImpl;
import com.chy.service.MusicService;
import com.chy.util.DateUtils;
import com.chy.util.PrtUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/9-14:47
 * @Since:jdk1.8
 * @Description:
 */
public class MusicAction {
    //曲库
    private List<Music> musicList;
    //已点歌曲列表
    private List<Music> musics;
    //扫描仪
    private Scanner sc;
    //接口注入
    private MusicService musicService = new MusicServiceImpl();

    /**
     * @author: chy
     * @Date: 2021/4/9 17:42
     * @Description: 构造方法, 初始化数据
     */
    public MusicAction() {
        musicList = new ArrayList<>(10);
        musics = new ArrayList<>(10);
        sc = new Scanner(System.in);
        //初始化
        initData();
    }

    /**
     * @author: chy
     * @Date: 2021/4/9 15:38
     * @Description: 初始化
     */
    private void initData() {
        //类别
        MusicType musicType1 = new MusicType(101, "流行歌曲");
        MusicType musicType2 = new MusicType(102, "经典老歌");

        //准备歌
        Music music1 = new Music(1, "东风破", "周杰伦", musicType1, "3:40", DateUtils.getNow(), 3);
        Music music2 = new Music(2, "青花瓷", "周杰伦", musicType1, "4:20", DateUtils.getNow(), 4);
        Music music3 = new Music(3, "晴天", "周杰伦", musicType1, "4:15", DateUtils.getNow(), 5);
        Music music4 = new Music(4, "海阔天空", "Beyond", musicType2, "5:05", DateUtils.getNow(), 6);
        Music music5 = new Music(5, "光辉岁月", "Beyond", musicType2, "4:35", DateUtils.getNow(), 7);
        Music music6 = new Music(6, "真的爱你", "Beyond", musicType2, "3:55", DateUtils.getNow(), 8);


        musicList.add(music1);
        musicList.add(music2);
        musicList.add(music3);
        musicList.add(music4);
        musicList.add(music5);
        musicList.add(music6);
    }

    /**
     * @author: chy
     * @Date: 2021/4/9 17:39
     * @Description: menu 菜单
     */
    public void menu() {
        PrtUtils.prt("********欢迎进入KTV点歌台*******");
        PrtUtils.prt("1、点歌");
        PrtUtils.prt("2、已点歌曲列表");
        PrtUtils.prt("0、退出系统");
        PrtUtils.prt("请选择:");
        int choose = sc.nextInt();
        switch (choose) {
            case 0:
                PrtUtils.prt("谢谢使用:");
                break;
            case 1:
                //点歌台
                chooseSongPlatform();
                break;
            case 2:
                //已点歌曲列表
                showAllChooseMusic();
                break;
            default:
                break;
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/9 15:55
     * @Description:点歌台
     */
    public void chooseSongPlatform() {
        PrtUtils.prt("********点歌台*******");
        PrtUtils.prt("1、按拼音点歌");
        PrtUtils.prt("2、按歌曲名点歌");
        PrtUtils.prt("3、按歌星点歌");
        PrtUtils.prt("4、按分类点歌");
        PrtUtils.prt("5、好歌排行榜");
        PrtUtils.prt("0、返回主菜单");
        PrtUtils.prt("请选择:");
        int choose = sc.nextInt();
        switch (choose) {
            case 0:
                //返回主菜单
                menu();
                break;
            case 1:
                //按拼音点歌
                Music music1 = musicService.callSongBySpell(musicList);
                musics.add(music1);
                chooseBack();
                break;
            case 2:
                //按歌曲名点歌
                Music music2 = musicService.callSongByName(musicList);
                musics.add(music2);
                chooseBack();
                break;
            case 3:
                //按歌星点歌
                Music music3 = musicService.callSongBySinger(musicList);
                musics.add(music3);
                chooseBack();
                break;
            case 4:
                //按分类点歌
                Music music4 = musicService.callSongByType(musicList);
                musics.add(music4);
                chooseBack();
                break;
            case 5:
                //好歌排行榜
                Music music5 = musicService.callSongByRant(musicList);
                musics.add(music5);
                chooseBack();
                break;
            default:
                break;
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/9 17:21
     * @Description: 选择返回的菜单
     */
    private void chooseBack() {
        PrtUtils.prt("********请选择返回*******");
        PrtUtils.prt("1、返回主菜单");
        PrtUtils.prt("2、返回点歌台");
        PrtUtils.prt("3、返回已点列表");
        PrtUtils.prt("请选择:");
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                menu();
                break;
            case 2:
                chooseSongPlatform();
                break;
            case 3:
                showAllChooseMusic();
                break;
            default:
                break;
        }

    }

    /**
     * @author: chy
     * @Date: 2021/4/9 17:23
     * @Description:已点歌曲列表
     */
    private void showAllChooseMusic() {
        PrtUtils.prt("********已点歌曲列表*******");
        for (int i = 1; i <= musics.size(); i++) {
            PrtUtils.prt(i + "\t" + musics.get(i - 1).getName() + "\t"
                    + musics.get(i - 1).getAuthor() + "\t" + musics.get(i - 1).getMusicLength());
        }
        PrtUtils.prt("********选择操作*******");
        PrtUtils.prt("1、歌曲前置");
        PrtUtils.prt("2、歌曲移除");
        PrtUtils.prt("3、歌曲前移一位");
        PrtUtils.prt("0、返回主菜单");
        PrtUtils.prt("请选择:");
        int choose = sc.nextInt();
        switch (choose) {
            case 0:
                menu();
                break;
            case 1:
                //前置歌曲
                musicService.preSong(musics);
                chooseBack();
                break;
            case 2:
                //移除歌曲
                musicService.deleteSong(musics);
                chooseBack();
                break;
            case 3:
                //上移歌曲
                musicService.forwardSong(musics);
                chooseBack();
                break;
            default:
                break;
        }
    }
}
