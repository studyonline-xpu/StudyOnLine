package com.study_online.service;

import com.study_online.pojo.Video;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */

public interface VideoService {
    public List<Video> queryVideoByClassId(String classId);
}
