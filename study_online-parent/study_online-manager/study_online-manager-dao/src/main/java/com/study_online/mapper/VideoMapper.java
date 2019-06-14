package com.study_online.mapper;

import com.study_online.pojo.Video;
import com.study_online.pojo.VideoExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface VideoMapper {
    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(String videoId);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExampleWithBLOBs(VideoExample example);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(String videoId);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExampleWithBLOBs(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKeyWithBLOBs(Video record);

    int updateByPrimaryKey(Video record);

    //自己写的方法
    /**
     * 根据类别查找课程
     * @param classId 类别id
     * @return
     */
    List<Video> queryVideoByClassId(String classId);
    /**
     * 根据点击量反序查询出热点视频
     */
    List<Video> queryHotVideo(Integer begin);
}