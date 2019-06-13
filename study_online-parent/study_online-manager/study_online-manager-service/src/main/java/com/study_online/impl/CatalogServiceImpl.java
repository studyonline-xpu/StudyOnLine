package com.study_online.impl;

import com.study_online.mapper.CatalogMapper;
import com.study_online.mapper.UserMapper;
import com.study_online.mapper.VideoMapper;
import com.study_online.pojo.Catalog;
import com.study_online.pojo.CatalogExample;
import com.study_online.pojo.User;
import com.study_online.pojo.Video;
import com.study_online.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    @Autowired
    UserMapper userMapper;
    /**
     * 根据视屏id查出视屏个所有一级章节
     * @param video_id
     * @return
     */
    @Override
    public List<Catalog> queryChapter(String video_id,String user_id) {
        //查询出所有的章节
        List<Catalog> chapters = catalogMapper.queryChapter(video_id);
        //查出每个章节的视屏
        for (Catalog chapter : chapters) {
            chapter.setCatalogs(catalogMapper.queryCatalogsByFatherId(chapter.getCatalogId()));
        }
        //增加点
        Video video = videoMapper.selectByPrimaryKey(video_id);
        video.setClicks(video.getClicks()+1);
        videoMapper.updateByPrimaryKeySelective(video);

        //查询该课程是否被收藏
        User user = userMapper.selectByPrimaryKey(user_id);
        String collect = user.getCollect();
        List<String> strings = Arrays.asList(collect.split(","));
       if(strings.contains(video_id)){
           for(Catalog c : chapters){
               c.setCollected(true);
           }
       }
        return chapters;
    }
}
