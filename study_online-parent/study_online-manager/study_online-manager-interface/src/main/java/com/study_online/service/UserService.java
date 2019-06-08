package com.study_online.service;

import com.study_online.pojo.User;
import com.study_online.pojo.VideoClass;

import java.util.List;
import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-06-01-21:43
 */
public interface UserService {
    List<VideoClass> queryVideoClassByFatherId(String fatherId);
    Map login(String appid,String secret,String js_code,String imgUrl,String nickName);
}
