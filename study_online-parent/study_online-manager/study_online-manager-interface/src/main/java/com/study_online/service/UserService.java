package com.study_online.service;

import com.study_online.pojo.User;
import com.study_online.pojo.Video;
import com.study_online.pojo.VideoClass;

import java.util.List;
import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-06-01-21:43
 */
public interface UserService {

    List<VideoClass> queryVideoClassByFatherId(String fatherId);

    /**
     * 用户登录，添加用户
     * @param appid
     * @param secret
     * @param js_code
     * @param imgUrl
     * @param nickName
     * @return
     */
    Map login(String appid,String secret,String js_code,String imgUrl,String nickName);

    /**
     * 查询收藏
     * @param user_id
     * @return
     */
    public List<Video> queryCollections(String user_id);
}
