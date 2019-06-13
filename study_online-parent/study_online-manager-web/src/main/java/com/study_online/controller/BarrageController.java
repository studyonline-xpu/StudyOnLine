package com.study_online.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.study_online.pojo.Barrage;
import com.study_online.service.BarrageService;
import com.study_online.userUtil.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-12
 */
@Controller
@RequestMapping("/barrage")
public class BarrageController {
    @Autowired
    BarrageService barrageService;


    /**
     * 根据目录id 查询弹幕
     * @param catalog_id 目录id
     * @return
     */
    @RequestMapping("/queryBarrage")
    @ResponseBody
    public List<Barrage> queryBarrage(String catalog_id){
        return barrageService.queryBarrage(catalog_id);
    }

    /**
     * 插入弹幕
     * @param barrageJson
     */
    @RequestMapping("/insertBarrage")
    @ResponseBody
    public void insertBarrage(String barrageJson){
        Barrage barrage =JsonUtils.jsonToPojo(barrageJson,Barrage.class);
        barrageService.insertBarrage(barrage);
    }

}
