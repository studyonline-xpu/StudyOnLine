package com.study_online.controller;

import com.study_online.pojo.VideoClass;
import com.study_online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-06-02-11:53
 */
@Controller
@RequestMapping("/videoClass")
public class VideoClassController {
    @Autowired
    UserService userService;
    @RequestMapping("/queryVideoClassByFatherId")
    @ResponseBody
    public List<VideoClass> queryVideoClassByFatherId(String fatherId){
        if (fatherId==null)
            fatherId = "0";
        List<VideoClass> videoClasses = userService.queryVideoClassByFatherId(fatherId);
        videoClasses.sort(new Comparator<VideoClass>() {
            @Override
            public int compare(VideoClass o1, VideoClass o2) {
                return (o1.getClassId()).compareTo(o1.getClassId());
            }
        });
        return videoClasses;
    }

}
