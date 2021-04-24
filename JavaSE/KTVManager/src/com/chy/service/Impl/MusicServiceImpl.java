package com.chy.service.Impl;

import com.chy.bean.Music;
import com.chy.service.MusicService;
import com.chy.util.DateUtils;
import com.chy.util.PrtUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/9-15:45
 * @Since:jdk1.8
 * @Description: 实现类
 */
public class MusicServiceImpl implements MusicService {

    static  Scanner sc = new Scanner(System.in);

    @Override
    public Music callSongBySpell(List<Music> musicList) {
        PrtUtils.prt("********欢迎使用拼音点歌********");
        PrtUtils.prt("请输入你要点歌的拼音:");
        String py = sc.next();
        //临时歌曲list
        List<Music> tempList = new ArrayList<>();
        for (Music music : musicList) {
            if (py.equals(music.getJpName()) || py.equals(music.getQpName())
                    || music.getJpName().startsWith(py) || music.getQpName().startsWith(py)) {
                tempList.add(music);
            }
        }
        return getMusicUtilInService(tempList, musicList);
    }

    @Override
    public Music callSongByName(List<Music> musicList) {
        PrtUtils.prt("********欢迎使用歌名点歌********");
        PrtUtils.prt("请输入你要点歌的歌名:");
        String name = sc.next();
        //临时歌曲list
        List<Music> tempList = new ArrayList<>();
        for (Music music : musicList) {
            if (name.equals(music.getName()) || music.getName().startsWith(name)) {
                tempList.add(music);
            }
        }
        return getMusicUtilInService(tempList, musicList);
    }

    @Override
    public Music callSongBySinger(List<Music> musicList) {
        PrtUtils.prt("********欢迎使用歌名点歌********");
        PrtUtils.prt("请输入你要点歌的歌手名:");
        String singer = sc.next();
        //临时歌曲list
        List<Music> tempList = new ArrayList<>();
        for (Music music : musicList) {
            if (singer.equals(music.getAuthor()) || music.getAuthor().startsWith(singer)) {
                tempList.add(music);
            }
        }
        return getMusicUtilInService(tempList, musicList);
    }

    @Override
    public Music callSongByType(List<Music> musicList) {
        PrtUtils.prt("********欢迎使用分类点歌********");
        //分类的列表
        List<String> typeList = new ArrayList();
        musicList.forEach(mus -> typeList.add(mus.getMusicType().getTypeName()));
        //分类去重
        List<String> collect = typeList.stream().distinct().collect(Collectors.toList());
        //显示
        collect.forEach(c -> System.out.print(c + "\t"));
        PrtUtils.prt("");
        PrtUtils.prt("请输入你要点的分类:");
        String type = sc.next();
        //临时歌曲list
        List<Music> tempList = new ArrayList<>();
        for (Music music : musicList) {
            if (music.getMusicType().getTypeName().equals(type) || music.getMusicType().getTypeName().startsWith(type)) {
                tempList.add(music);
            }
        }
        return getMusicUtilInService(tempList, musicList);
    }

    @Override
    public Music callSongByRant(List<Music> musicList) {
        PrtUtils.prt("********好歌排行榜********");
        musicList.sort((o1, o2) -> {
            if (o1.getCount() > o2.getCount()) {
                return -1;
            }
            if (o1.getCount().equals(o2.getCount())) {
                return 0;
            } else {
                return 1;
            }
        });
        PrtUtils.prt("序号" + "\t歌曲名" + "\t歌手" + "\t\t时长" +"            "+ "\t上架时间" +"\t\t点歌次数");
        musicList.forEach(music -> PrtUtils.prt(music.getId() + "\t" + music.getName() + "\t" + music.getAuthor() +
                "\t" + music.getMusicLength() + "\t" + DateUtils.showDate(music.getUpTime()) + "\t\t\t" + music.getCount()));
        PrtUtils.prt("********点歌,输入歌名********");
        String name = sc.next();
        //临时歌曲list
        Music musicResult = new Music();
        for (Music music : musicList) {
            if (name.equals(music.getName())) {
                musicResult = music;
            }
        }
        //count++
        Music finalMusicResult = musicResult;
        musicList.forEach(music -> {
            if (music.equals(finalMusicResult)) {
                music.setCount(music.getCount() + 1);

            }
        });
        PrtUtils.prt("点歌成功，已将[" + musicResult.getName() + "]添加到歌曲列表中");
        return musicResult;
    }

    @Override
    public void preSong(List<Music> musics) {

        PrtUtils.prt("请选择你要置顶的歌曲");
        String preName = sc.next();
        Music perSongs = new Music();
        for (Music music : musics) {
            if (music.getName().equals(preName)) {
                perSongs = music;
            }
        }
        if (perSongs.getName() != null) {
            Music remove = musics.remove(musics.indexOf(perSongs));
            musics.add(0, remove);
            PrtUtils.prt("置顶成功，已将[" + remove.getName() + "]置顶歌曲列表");
        }

    }

    @Override
    public void deleteSong(List<Music> musics) {
        PrtUtils.prt("请选择你要移除的歌曲");
        String preName = sc.next();
        Music perSongs = new Music();
        for (Music music : musics) {
            if (music.getName().equals(preName)) {
                perSongs = music;
            }
        }
        if (perSongs.getName() != null) {
            Music remove = musics.remove(musics.indexOf(perSongs));
            PrtUtils.prt("移除成功，已将[" + remove.getName() + "]移除歌曲列表");
        }

    }

    @Override
    public void forwardSong(List<Music> musics) {
        PrtUtils.prt("请选择你要前移的歌曲");
        String preName = sc.next();

        //前移的歌曲
        Music musicChoose = new Music();
        for (Music music : musics) {
            if (music.getName().equals(preName)) {
                musicChoose = music;
            }
        }
        int j = 0;
        for (int i = 0; i < musics.size(); i++) {
            if (musics.get(i).equals(musicChoose)) {
                j = i;
                musicChoose = musics.get(i);
            }
        }
        musics.remove(musicChoose);
        musics.add(j - 1, musicChoose);
        PrtUtils.prt("前移成功，已将[" + musicChoose.getName() + "]前移歌曲列表");
    }


    /**
     * @author: chy
     * @Date: 2021/4/9 16:50
     * @Description: 获取歌曲 抽取方法
     */
    private Music getMusicUtilInService(List<Music> tempList, List<Music> musicList) {
        PrtUtils.prt("序号" + "\t歌曲名" + "\t歌手" + "\t\t时长");
        tempList.forEach(music -> PrtUtils.prt(music.getId() + "\t" + music.getName() + "\t"
                + music.getAuthor() + "\t" + music.getMusicLength()));
        PrtUtils.prt("********点歌,输入歌名********");
        String musName = sc.next();
        Music musicResult = new Music();
        for (Music music : tempList) {
            if (music.getName().equals(musName)) {
                musicResult = music;
            }
        }
        if (musicResult.getName().isEmpty()) {
            //失败
            PrtUtils.prt("点歌失败，没有该首歌曲。可反馈给管理员，尽请期待");
        } else {
            //成功 count++
            Music finalMusicResult = musicResult;
            musicList.forEach(music -> {
                if (music.equals(finalMusicResult)) {
                    music.setCount(music.getCount() + 1);
                }
            });
            PrtUtils.prt("点歌成功，已将[" + musicResult.getName() + "]添加到歌曲列表中");
        }
        return musicResult;
    }
}