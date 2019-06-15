package com.study_online.impl;

import com.study_online.mapper.HistoryMapper;
import com.study_online.mapper.UserMapper;
import com.study_online.mapper.VideoMapper;
import com.study_online.pojo.User;
import com.study_online.pojo.Video;
import com.study_online.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**查询历史浏览
 * @author 刘棋军
 * @date2019-06-14
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    UserMapper userMapper;

    /**
     * 查询最近浏览
     * @param user_id
     * @return
     */
    @Override
    public List<Video> queryHistory(String user_id) {
        List<Video> videos = videoMapper.queryHistory(user_id);
        for (Video video : videos) {
            User user = userMapper.selectByPrimaryKey(video.getUserId());
            video.setUserName(user.getUserName());
            video.setUserPicture(user.getPicture());
        }
        return videos;
    }
}
