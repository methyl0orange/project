package com.mszlu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszlu.blog.dao.mapper.CommentMapper;
import com.mszlu.blog.dao.pojo.Comment;
import com.mszlu.blog.service.CommentsService;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.vo.CommentVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SysUserService sysUserService;
    @Override
    public Result commentsByArticleId(Long id) {
        /**
         * 根据文章id查看所有的评论列表
         * 根据文章差评论列表
         * 根据作者id查询作者信息
         * 判断如果level=1 看看是否铀之评论
         * 如果有根据评论ID进行查询
         */

        LambdaQueryWrapper<Comment> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getArticleId,id);
        lambdaQueryWrapper.eq(Comment::getLevel,1);
        List<Comment>comments=commentMapper.selectList(lambdaQueryWrapper);
        List<CommentVo> commentVoList=copyList(comments);
        return Result.success(commentVoList);
    }

    private List<CommentVo> copyList(List<Comment> comments) {
        List<CommentVo> commentVoList=new ArrayList<>();
        for(Comment comment:comments){
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }

    private CommentVo copy(Comment comment) {
        CommentVo commentVo=new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        //作者信息
        Long authorId=comment.getAuthorId();
        UserVo userVo = this.sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        //子评论
        Integer level=comment.getLevel();
        if(level==1){
            Long id=comment.getId();
            List<CommentVo> commentVoList=findCommentsByParentId(id);
            commentVo.setChildrens(commentVoList);
        }
        //toUser
        if(level>1){
            Long toUid=comment.getToUid();
            UserVo toUserVo=this.sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getArticleId,id);
        lambdaQueryWrapper.eq(Comment::getLevel,2);
        return copyList(commentMapper.selectList(lambdaQueryWrapper));
    }
}
