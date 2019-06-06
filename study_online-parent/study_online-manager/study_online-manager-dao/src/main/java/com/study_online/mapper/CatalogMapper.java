package com.study_online.mapper;

import com.study_online.pojo.Catalog;
import com.study_online.pojo.CatalogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    long countByExample(CatalogExample example);

    int deleteByExample(CatalogExample example);

    int deleteByPrimaryKey(String catalogId);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    List<Catalog> selectByExampleWithBLOBs(CatalogExample example);

    List<Catalog> selectByExample(CatalogExample example);

    Catalog selectByPrimaryKey(String catalogId);

    int updateByExampleSelective(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByExampleWithBLOBs(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByExample(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKeyWithBLOBs(Catalog record);

    int updateByPrimaryKey(Catalog record);

    void selectByExampleWithBLOBs();

    //自己写的方法

    /**
     * 根据视频id获取章节信息
     * @param video_id 视频id
     * @return
     */
    List<Catalog> queryChapter(String video_id);

    /**
     * 根据章节id查询此章节目录集合
     * @param fatherId 章节id
     * @return
     */
    List<Catalog> queryCatalogsByFatherId(String fatherId);
}