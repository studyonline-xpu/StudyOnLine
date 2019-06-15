package com.study_online.controller;

import com.study_online.pojo.Video;
import com.study_online.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-14
 */
@RequestMapping("/history")
@Controller
public class HistoryController {
    @Autowired
    HistoryService historyService;


    /**
     * 查询最近浏览
     * @param user_id
     * @return
     */
    @RequestMapping("/queryHistory")
    @ResponseBody
    public List<Video> queryHistory(String user_id){
        return  historyService.queryHistory(user_id);
    }
}
