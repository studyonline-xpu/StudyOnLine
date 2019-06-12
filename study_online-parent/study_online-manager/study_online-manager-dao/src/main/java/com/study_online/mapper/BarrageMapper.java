package com.study_online.mapper;

import com.study_online.pojo.Barrage;
import com.study_online.pojo.BarrageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BarrageMapper {
    long countByExample(BarrageExample example);

    int deleteByExample(BarrageExample example);

    int deleteByPrimaryKey(String barrageId);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    List<Barrage> selectByExample(BarrageExample example);

    Barrage selectByPrimaryKey(String barrageId);

    int updateByExampleSelective(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByExample(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}