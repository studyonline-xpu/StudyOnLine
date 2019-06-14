package com.study_online.controller;

import com.study_online.pojo.Video;
import com.study_online.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张聪
 * @date 2019-06-08
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> Login(String appid,String secret,String js_code,String imgUrl,String nickName) {
        return userService.login(appid,secret,js_code,imgUrl,nickName);
    }

    /**
     * 查询用于收藏的所有课程
     * @param user_id
     * @return
     */
    @RequestMapping("/queryCollections")
    @ResponseBody
    public List<Video> queryCollections(String user_id){
        return userService.queryCollections(user_id);
    }
}
