package com.study_online.service;

import com.study_online.pojo.Video;

import java.util.List;

/**
 * 查询历史记录
 * @author 刘棋军
 * @date2019-06-14
 */

public interface HistoryService {
   public List<Video> queryHistory();
}
