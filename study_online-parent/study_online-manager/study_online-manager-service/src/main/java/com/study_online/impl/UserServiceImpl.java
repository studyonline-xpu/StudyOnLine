package com.study_online.impl;

import com.study_online.mapper.UserMapper;
import com.study_online.mapper.VideoClassMapper;
import com.study_online.pojo.User;
import com.study_online.pojo.UserExample;
import com.study_online.pojo.VideoClass;
import com.study_online.service.UserService;
import com.study_online.userUtil.HttpRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Map login(String appid,String secret,String js_code,String imgUrl,String nickName) {
        Map map = new HashMap<>();
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
        //新创建一个用户
        User user = new User();
        user.setUserId(openid);
        user.setUserName(nickName);
        user.setPicture(imgUrl);
        user.setCreateTime(new Date());
        //返回session_key和openid
        map.put("status",userMapper.insertSelective(user));
        map.put("session_key", session_key);
        map.put("openid", openid);
        return map;
    }

    /**
     * 查询用户的收藏课程
     * @param user_id
     * @return
     */
    @Override
    public String[] queryCollections(String user_id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user_id);
        List<User> users = userMapper.selectByExampleWithBLOBs(example);
        String collection = users.get(0).getCollect();
        String[] split = collection.split(",");

        return split;
    }
}