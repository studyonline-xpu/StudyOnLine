package com.study_online.mapper;

import com.study_online.pojo.VideoClass;
import com.study_online.pojo.VideoClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoClassMapper {
    long countByExample(VideoClassExample example);

    int deleteByExample(VideoClassExample example);

    int deleteByPrimaryKey(String classId);

    int insert(VideoClass record);

    int insertSelective(VideoClass record);

    List<VideoClass> selectByExample(VideoClassExample example);

    VideoClass selectByPrimaryKey(String classId);

    int updateByExampleSelective(@Param("record") VideoClass record, @Param("example") VideoClassExample example);

    int updateByExample(@Param("record") VideoClass record, @Param("example") VideoClassExample example);

    int updateByPrimaryKeySelective(VideoClass record);

    int updateByPrimaryKey(VideoClass record);
}