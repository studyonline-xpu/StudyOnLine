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


    @RequestMapping("/queryBarrage")
    @ResponseBody
    public List<Barrage> queryBarrage(String catalog_id){
        return barrageService.queryBarrage(catalog_id);
    }

    @RequestMapping("/insertBarrage")
    @ResponseBody
    public void insertBarrage(String barrage){
        Barrage b =JsonUtils.jsonToPojo(barrage,Barrage.class);
        barrageService.insertBarrage(b);
    }

}
