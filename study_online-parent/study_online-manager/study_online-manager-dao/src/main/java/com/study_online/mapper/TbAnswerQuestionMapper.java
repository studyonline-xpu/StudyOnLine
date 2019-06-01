package com.study_online.mapper;

import java.util.List;

import com.study_online.pojo.TbAnswerQuestion;
import com.study_online.pojo.TbAnswerQuestionExample;
import org.apache.ibatis.annotations.Param;

public interface TbAnswerQuestionMapper {
    long countByExample(TbAnswerQuestionExample example);

    int deleteByExample(TbAnswerQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbAnswerQuestion record);

    int insertSelective(TbAnswerQuestion record);

    List<TbAnswerQuestion> selectByExample(TbAnswerQuestionExample example);

    TbAnswerQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAnswerQuestion record, @Param("example") TbAnswerQuestionExample example);

    int updateByExample(@Param("record") TbAnswerQuestion record, @Param("example") TbAnswerQuestionExample example);

    int updateByPrimaryKeySelective(TbAnswerQuestion record);

    int updateByPrimaryKey(TbAnswerQuestion record);
}