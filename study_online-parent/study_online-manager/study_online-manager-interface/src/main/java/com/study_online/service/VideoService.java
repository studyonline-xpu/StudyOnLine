package com.study_online.service;

import com.study_online.pojo.Video;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */

public interface VideoService {
    /**
     * 通过课程类型查询所有的该类课程
     * @param classId
     * @return
     */
    public List<Video> queryVideoByClassId(String classId);

    /**
     * 查询热点课程，用于首页的推荐
     * @return
     */
    public List<Video> queryHotVideo(Integer begin);
    /**
     * 点赞函数
     */
    public void  addLikes(String video_id);

    /**
     * 点击收藏函数
     * @param video_id
     * @param user_id
     */
    public void addCollect(String video_id,String user_id);
}
