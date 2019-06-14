package com.study_online.controller;

import com.study_online.pojo.Catalog;
import com.study_online.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-05
 */

@RequestMapping("/catalog")
@Controller
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    /**
     * 通过视的video_id 查询课程的一级章节
     * @param video_id
     * @param user_id
     * @return
     */
    @RequestMapping("/queryChapters")
    @ResponseBody
    public List<Catalog> queryChapters(String video_id,String user_id){
        return catalogService.queryChapter(video_id,user_id);
    }
}
