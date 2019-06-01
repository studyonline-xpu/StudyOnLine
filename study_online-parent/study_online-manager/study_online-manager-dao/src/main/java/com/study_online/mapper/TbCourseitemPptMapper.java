package com.study_online.mapper;

import com.smart.pojo.TbCourseitemPpt;
import com.smart.pojo.TbCourseitemPptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCourseitemPptMapper {
    long countByExample(TbCourseitemPptExample example);

    int deleteByExample(TbCourseitemPptExample example);

    int deleteByPrimaryKey(String courseitemId);

    int insert(TbCourseitemPpt record);

    int insertSelective(TbCourseitemPpt record);

    List<TbCourseitemPpt> selectByExample(TbCourseitemPptExample example);

    TbCourseitemPpt selectByPrimaryKey(String courseitemId);

    int updateByExampleSelective(@Param("record") TbCourseitemPpt record, @Param("example") TbCourseitemPptExample example);

    int updateByExample(@Param("record") TbCourseitemPpt record, @Param("example") TbCourseitemPptExample example);

    int updateByPrimaryKeySelective(TbCourseitemPpt record);

    int updateByPrimaryKey(TbCourseitemPpt record);
}