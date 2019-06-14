package com.study_online.mapper;

import com.study_online.pojo.History;
import com.study_online.pojo.HistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper {
    long countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int deleteByPrimaryKey(@Param("videoId") String videoId, @Param("userId") String userId);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);

    History selectByPrimaryKey(@Param("videoId") String videoId, @Param("userId") String userId);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}