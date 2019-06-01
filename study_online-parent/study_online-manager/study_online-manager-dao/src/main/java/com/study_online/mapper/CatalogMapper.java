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
}