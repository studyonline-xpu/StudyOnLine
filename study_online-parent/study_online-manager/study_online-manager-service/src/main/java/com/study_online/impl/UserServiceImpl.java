package com.study_online.impl;

import com.study_online.mapper.UserMapper;
import com.study_online.mapper.VideoClassMapper;
import com.study_online.pojo.User;
import com.study_online.pojo.VideoClass;
import com.study_online.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-06-01-21:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    VideoClassMapper classMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<VideoClass> queryVideoClassByFatherId(String fatherId) {
        return classMapper.queryVideoClassByFatherId(fatherId);
    }

    /**
     * @author 张聪
     * @create 2019-06-08
     */
    @Override
    public Map<String, String> login(String appid,String secret,String js_code,String imgUrl,String nickName) {
        Map<String, String> map = new HashMap<>();
        Map map = new HashMap();
        //登录凭证不能为空
        if (js_code == null || js_code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = appid;
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = secret;
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + js_code ;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        System.out.println(openid);
        System.out.println(session_key);
        System.out.println(imgUrl);
        System.out.println(nickName);
        map.put("status",String.valueOf(userMapper.insertSelective(user)));
        return map;
    }
}