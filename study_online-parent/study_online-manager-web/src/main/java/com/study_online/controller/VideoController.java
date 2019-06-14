package com.study_online.controller;

import com.study_online.pojo.Video;
import com.study_online.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */
@Controller
@RequestMapping("/video")

public class VideoController {
    @Autowired
    VideoService videoService;

    /**
     * 通过课程类型查询出所有的该类课程
     * @param classId
     * @return
     */
    @RequestMapping("/queryVideoByClassId")
    @ResponseBody
    public List<Video> queryVideoByClassId(String classId){
        return videoService.queryVideoByClassId(classId);
    }

    /**
     * 查询热点课程，用于首页的推荐
     * @return
     */
    @RequestMapping("/queryHotVideo")
    @ResponseBody
    public List<Video> queryHotVideo(Integer begin){
        return videoService.queryHotVideo(begin);
    }

    /**
     * 点赞函数
     * @param video_id
     */
    @RequestMapping("/addLikes")
    @ResponseBody
    public void addLikes(String video_id){
        videoService.addLikes(video_id);
    }

    /**
     * 点击收藏函数
     * @param video_id
     * @param user_id
     */
    @RequestMapping("/addCollect")
    @ResponseBody
    public void addCollect(String video_id, String user_id){
       videoService.addCollect(video_id,user_id);
    }

}
