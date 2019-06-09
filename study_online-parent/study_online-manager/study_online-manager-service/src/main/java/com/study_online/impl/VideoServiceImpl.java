package com.study_online.impl;

import com.study_online.mapper.UserMapper;
import com.study_online.mapper.VideoMapper;
import com.study_online.pojo.User;
import com.study_online.pojo.UserExample;
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
    @Autowired
    UserMapper userMapper;

    /**
     * 通过课程类型查出所有的该类课程
     * @param classId
     * @return
     */
    @Override
    public List<Video> queryVideoByClassId(String classId) {
        List<Video> videos = videoMapper.queryVideoByClassId(classId);
        for (Video video : videos) {
            User user = userMapper.selectByPrimaryKey(video.getUserId());
            video.setUserName(user.getUserName());
            video.setUserPicture(user.getPicture());
        }
        return videos;
    }

    /**
     * 查询热点视屏，用于首页推荐
     * @return
     */
    @Override
    public List<Video> queryHotVideo() {
        List<Video> videos = videoMapper.queryHotVideo();
        for (Video video : videos) {
            User user = userMapper.selectByPrimaryKey(video.getUserId());
            video.setUserName(user.getUserName());
            video.setUserPicture(user.getPicture());
        }
        return videos;
    }

    /**
     * 点赞函数
     */
    @Override
    public void addLikes(String video_id) {
        //1.根据video_id查询出该 课程的当前点击量
        Video video = videoMapper.selectByPrimaryKey(video_id);
        //2.将点击量加1，更新数据
        video.setLikes(video.getLikes()+1);
        videoMapper.updateByPrimaryKeySelective(video);
    }

    /**
     * 点击收藏
     * @param video_id
     * @param user_id
     */
    @Override
    public void addCollect(String video_id, String user_id) {
        //1.更新视屏的收藏量
        Video video = videoMapper.selectByPrimaryKey(video_id);
        video.setCollections(video.getCollections()+1);
        videoMapper.updateByPrimaryKeySelective(video);
        //2.将收藏记录添加到user表中
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user_id);
        List<User> users = userMapper.selectByExampleWithBLOBs(example);
        User user = users.get(0);
        String collect = user.getCollect();
        if(collect == null || collect.trim().equals("")){
            collect = video_id;
        }else{
            collect = collect + "," +video_id;
        }
        user.setCollect(collect);
        userMapper.updateByPrimaryKeyWithBLOBs(user);
    }
}
