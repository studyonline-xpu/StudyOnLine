package com.study_online.mapper;

import java.util.List;

import com.study_online.pojo.TbCollegeitem;
import com.study_online.pojo.TbCollegeitemExample;
import org.apache.ibatis.annotations.Param;

public interface TbCollegeitemMapper {
    long countByExample(TbCollegeitemExample example);

    int deleteByExample(TbCollegeitemExample example);

    int deleteByPrimaryKey(String collegeId);

    int insert(TbCollegeitem record);

    int insertSelective(TbCollegeitem record);

    List<TbCollegeitem> selectByExample(TbCollegeitemExample example);

    TbCollegeitem selectByPrimaryKey(String collegeId);

    int updateByExampleSelective(@Param("record") TbCollegeitem record, @Param("example") TbCollegeitemExample example);

    int updateByExample(@Param("record") TbCollegeitem record, @Param("example") TbCollegeitemExample example);

    int updateByPrimaryKeySelective(TbCollegeitem record);

    int updateByPrimaryKey(TbCollegeitem record);
}