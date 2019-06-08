package com.study_online.service;

import com.study_online.pojo.Comments;

import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-08
 */

public interface CommentService {
    /**
     * 根据father_id查询评论
     */
    public List<Comments> queryComments(String father_id);
}
