package com.study_online.impl;

import com.study_online.mapper.VideoClassMapper;
import com.study_online.pojo.VideoClass;
import com.study_online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LM_Code
 * @create 2019-06-01-21:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    VideoClassMapper classMapper;
    @Override
    public List<VideoClass> queryVideoClassByFatherId(String fatherId) {
        return classMapper.queryVideoClassByFatherId(fatherId);
    }
}