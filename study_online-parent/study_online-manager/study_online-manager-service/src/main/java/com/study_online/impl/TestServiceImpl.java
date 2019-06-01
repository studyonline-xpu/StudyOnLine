package com.study_online.impl;

import com.study_online.mapper.TestMapper;
import com.study_online.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘棋军
 * @date2019-05-28
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    @Override
    public String queryNow() {
        return testMapper.queryNow();
    }
}
