package com.mszlu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<Archives> listArchives();
}
