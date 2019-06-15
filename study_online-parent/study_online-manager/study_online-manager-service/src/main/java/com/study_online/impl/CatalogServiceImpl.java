package com.study_online.impl;

import com.study_online.mapper.CatalogMapper;
import com.study_online.mapper.HistoryMapper;
import com.study_online.mapper.UserMapper;
import com.study_online.mapper.VideoMapper;
import com.study_online.pojo.*;
import com.study_online.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
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
    @Autowired
    HistoryMapper historyMapper;
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
        //增加点击量
        Video video = videoMapper.selectByPrimaryKey(video_id);
        video.setClicks(video.getClicks()+1);
        videoMapper.updateByPrimaryKeySelective(video);

        //查询该课程是否被收藏
        User user = userMapper.selectByPrimaryKey(user_id);
        System.out.println(user);
        if(user.getCollect() != null ){
            String collect = user.getCollect();
            List<String> strings = Arrays.asList(collect.split(","));
            if(strings.contains(video_id)){
                for(Catalog c : chapters){
                    c.setCollected(true);
                }
            }
        }

       //更新用户的最近浏览
        //1.查询该视屏是否在浏览记录中，有的话直接更新时间即可没有插入
        History history = historyMapper.selectByPrimaryKey(video_id, user_id);
       if(history != null){
           history.setTime(new Date());
           historyMapper.updateByPrimaryKeySelective(history);
       }else {
          History history1 = new History();
           history1.setVideoId(video_id);
           history1.setUserId(user_id);
           history1.setTime(new Date());
           historyMapper.insert(history1);
       }
        return chapters;
    }
}
