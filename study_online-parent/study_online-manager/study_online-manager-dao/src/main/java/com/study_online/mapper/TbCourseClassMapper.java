package com.study_online.mapper;

import java.util.List;

import com.study_online.pojo.TbCourseClass;
import com.study_online.pojo.TbCourseClassExample;
import org.apache.ibatis.annotations.Param;

public interface TbCourseClassMapper {
    long countByExample(TbCourseClassExample example);

    int deleteByExample(TbCourseClassExample example);

    int deleteByPrimaryKey(@Param("courseId") String courseId, @Param("classId") String classId);

    int insert(TbCourseClass record);

    int insertSelective(TbCourseClass record);

    List<TbCourseClass> selectByExample(TbCourseClassExample example);

    int updateByExampleSelective(@Param("record") TbCourseClass record, @Param("example") TbCourseClassExample example);

    int updateByExample(@Param("record") TbCourseClass record, @Param("example") TbCourseClassExample example);
}