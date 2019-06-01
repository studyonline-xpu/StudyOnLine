package com.study_online.controller;

import com.study_online.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘棋军
 * @date2019-05-28
 */
@Controller
public class TestController {
    @Autowired
    private TestService service;


    @RequestMapping("/test/queryNow")
    @ResponseBody
    public String queryNow(){
        System.out.println(service.queryNow());
        return service.queryNow();
    }
    

}
