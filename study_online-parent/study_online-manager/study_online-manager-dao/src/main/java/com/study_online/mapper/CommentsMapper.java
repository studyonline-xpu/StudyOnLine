package com.study_online.mapper;


import com.study_online.pojo.Comments;
import com.study_online.pojo.CommentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsMapper {
    long countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(String commentsId);

    int insert(Comments record);

    int insertSelective(Comments record);

    List<Comments> selectByExampleWithBLOBs(CommentsExample example);

    List<Comments> selectByExample(CommentsExample example);

    Comments selectByPrimaryKey(String commentsId);

    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);
}