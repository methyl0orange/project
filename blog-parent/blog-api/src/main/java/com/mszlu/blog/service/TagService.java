package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.TagVo;


import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticledId(Long articleId);
    Result hots(int limit);
}
