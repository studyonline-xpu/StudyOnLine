package com.study_online.controller;

import com.study_online.pojo.Comments;
import com.study_online.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-08
 */
@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 根据father_id查询评论
     * @return
     */
    @RequestMapping("/queryComments")
    @ResponseBody
    public List<Comments> queryComments(String father_id){
        return commentService.queryComments(father_id);
    }
}
