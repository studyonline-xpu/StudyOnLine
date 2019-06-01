package com.study_online.mapper;

import com.smart.pojo.TbCourseitemHomework;
import com.smart.pojo.TbCourseitemHomeworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCourseitemHomeworkMapper {
    long countByExample(TbCourseitemHomeworkExample example);

    int deleteByExample(TbCourseitemHomeworkExample example);

    int deleteByPrimaryKey(@Param("courseitemId") String courseitemId, @Param("studentId") String studentId);

    int insert(TbCourseitemHomework record);

    int insertSelective(TbCourseitemHomework record);

    List<TbCourseitemHomework> selectByExample(TbCourseitemHomeworkExample example);

    TbCourseitemHomework selectByPrimaryKey(@Param("courseitemId") String courseitemId, @Param("studentId") String studentId);

    int updateByExampleSelective(@Param("record") TbCourseitemHomework record, @Param("example") TbCourseitemHomeworkExample example);

    int updateByExample(@Param("record") TbCourseitemHomework record, @Param("example") TbCourseitemHomeworkExample example);

    int updateByPrimaryKeySelective(TbCourseitemHomework record);

    int updateByPrimaryKey(TbCourseitemHomework record);
}