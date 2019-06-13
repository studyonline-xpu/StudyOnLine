package com.study_online.impl;

import com.study_online.mapper.BarrageMapper;
import com.study_online.pojo.Barrage;
import com.study_online.pojo.BarrageExample;
import com.study_online.service.BarrageService;
import com.study_online.userUtil.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-12
 */
@Service
public class BarrageServiceImpl implements BarrageService {
    @Autowired
    BarrageMapper barrageMapper;
    @Override
    public List<Barrage> queryBarrage(String catalog_id) {
        BarrageExample example = new BarrageExample();
        BarrageExample.Criteria criteria = example.createCriteria();
        criteria.andCatalogIdEqualTo(catalog_id);
        List<Barrage> barrages = barrageMapper.selectByExample(example);
        return barrages;
    }

    @Override
    public void insertBarrage(Barrage barrage) {
        String barrage_id = IDUtils.genItemId();
        System.out.println(barrage);
        barrage.setBarrageId(barrage_id);
        barrageMapper.insert(barrage);
    }
}
