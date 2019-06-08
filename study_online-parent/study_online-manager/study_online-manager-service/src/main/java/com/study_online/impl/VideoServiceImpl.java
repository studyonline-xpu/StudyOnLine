package com.study_online.impl;

import com.study_online.mapper.VideoMapper;
import com.study_online.pojo.Video;
import com.study_online.pojo.VideoExample;
import com.study_online.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public List<Video> queryVideoByClassId(String classId) {
        List<Video> videos = videoMapper.queryVideoByClassId(classId);
        return videos;
    }

    @Override
    public List<Video> queryHotVideo() {
       return videoMapper.queryHotVideo();
    }
}
