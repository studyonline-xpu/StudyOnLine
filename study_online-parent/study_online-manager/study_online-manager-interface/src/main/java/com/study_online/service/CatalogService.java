package com.study_online.service;

import com.study_online.pojo.Catalog;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */

public interface CatalogService {
    public List<Catalog> queryChapter(String video_id);
}
