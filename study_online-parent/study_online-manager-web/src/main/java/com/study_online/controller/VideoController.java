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
    @RequestMapping("queryVideoByClassId")
    @ResponseBody
    public List<Video> queryVideoByClassId(String classId){
        return videoService.queryVideoByClassId(classId);
    }
}
