package com.study_online.service;

import com.study_online.pojo.Barrage;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-12
 */

public interface BarrageService {
    /**
     * 查询弹幕
     * @param catalog_id
     * @return
     */
    public List<Barrage> queryBarrage(String catalog_id);

    /**
     * 插入弹幕
     * @param barrage
     */
    public void insertBarrage(Barrage barrage);
}
