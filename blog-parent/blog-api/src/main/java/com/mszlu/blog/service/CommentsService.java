package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;

public interface CommentsService {
    Result commentsByArticleId(Long id);
}
