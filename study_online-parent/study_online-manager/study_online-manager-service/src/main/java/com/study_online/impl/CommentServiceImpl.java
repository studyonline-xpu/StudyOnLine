package com.study_online.impl;

import com.study_online.mapper.CommentsMapper;
import com.study_online.pojo.Comments;
import com.study_online.pojo.CommentsExample;
import com.study_online.service.CommentService;
import com.study_online.userUtil.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 刘棋军
 * @date2019-06-08
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentsMapper commentsMapper;

    /**
     * 根据father_id查询评论是实现类方法
     * @param father_id
     * @return
     */
    @Override
    public List<Comments> queryComments(String father_id) {
        CommentsExample example = new CommentsExample();
        CommentsExample.Criteria criteria = example.createCriteria();
        criteria.andFatherIdEqualTo(father_id);
        List<Comments> comments = commentsMapper.selectByExampleWithBLOBs(example);
        return comments;
    }

    /**
     * 插入评论
     * @param comments
     */
    @Override
    public void insertComments(Comments comments) {
        comments.setCommentsId(IDUtils.genItemId());
        //将被评论的评论改为父级评论
        if(comments.getFatherId() != null && !comments.getFatherId().trim().equals("") ){
            Comments comments1 = commentsMapper.selectByPrimaryKey(comments.getFatherId());
            if(!comments1.getIsFather()){
                comments1.setIsFather(true);
                commentsMapper.updateByPrimaryKeySelective(comments1);
            }
        }
        comments.setTime(new Date());
        comments.setIsFather(false);
        commentsMapper.insert(comments);
    }
}
