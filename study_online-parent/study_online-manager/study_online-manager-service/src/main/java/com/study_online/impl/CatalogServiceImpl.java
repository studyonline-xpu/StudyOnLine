package com.study_online.impl;

import com.study_online.mapper.CatalogMapper;
import com.study_online.mapper.VideoMapper;
import com.study_online.pojo.Catalog;
import com.study_online.pojo.CatalogExample;
import com.study_online.pojo.Video;
import com.study_online.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    CatalogMapper catalogMapper;
    @Autowired
    VideoMapper videoMapper;
    @Override
    public List<Catalog> queryChapter(String video_id) {
        CatalogExample example = new CatalogExample();
        CatalogExample.Criteria criteria = example.createCriteria();
        criteria.andVideoIdEqualTo(video_id);
        criteria.andFatherIdEqualTo("0");
        List<Catalog> chapters = catalogMapper.selectByExampleWithBLOBs(example);
        Video video = videoMapper.selectByPrimaryKey(video_id);
        video.setClicks(video.getClicks()+1);
        videoMapper.updateByPrimaryKeySelective(video);
        return chapters;
    }

    @Override
    public List<Catalog> queryVideoCatalog(String chapter_id) {
        CatalogExample example = new CatalogExample();
        CatalogExample.Criteria criteria = example.createCriteria();
        criteria.andFatherIdEqualTo(chapter_id);
        return catalogMapper.selectByExampleWithBLOBs(example);

    }

}
