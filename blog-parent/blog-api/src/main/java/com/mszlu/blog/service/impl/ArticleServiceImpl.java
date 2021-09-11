package com.mszlu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.mapper.ArticleBodyMapper;
import com.mszlu.blog.dao.mapper.ArticleMapper;
import com.mszlu.blog.dao.pojo.Article;
import com.mszlu.blog.dao.pojo.ArticleBody;
import com.mszlu.blog.service.*;
import com.mszlu.blog.vo.ArticleBodyVo;
import com.mszlu.blog.vo.ArticleVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.ArticleParam;
import com.mszlu.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagService tagService;
    @Autowired
    private SysUserService sysUserService;


    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> page=new Page<>(pageParams.getPage(),pageParams.getPageSize());

        LambdaQueryWrapper<Article> articleLambdaQueryWrapper=new LambdaQueryWrapper<>();
        //是否置顶排序
        //order by create_date desc
        articleLambdaQueryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        Page<Article> articlePage=articleMapper.selectPage(page,articleLambdaQueryWrapper);
        List<Article> records=articlePage.getRecords();
        //能直接返回吗？ 很明显不能
        List<ArticleVo> articleVoList = copyList(records,true,true);
        return Result.success(articleVoList);
    }
    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record,isTag,isAuthor,false,false));
        }
        return articleVoList;
    }

    @Autowired
    private CategoryService categoryService;
    private ArticleVo copy(Article article,boolean isTag, boolean isAuthor, boolean isBody,boolean isCategory){

        ArticleVo articleVo=new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        //并不是所有接口都需要标签，作者信息
        if(isTag){
            Long articledId=article.getId();
            articleVo.setTags(tagService.findTagsByArticledId(articledId));
        }
        if(isAuthor){
            Long authorId=article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserVoById(authorId).getNickname());
        }
        if(isBody){
            Long bodyId=article.getBodyId();
            articleVo.setBody(findArticleBodyById(bodyId));
        }
        if(isCategory){
            Long categoryId=article.getCategoryId();
            articleVo.setCategory(categoryService.findCategoryById(categoryId));
        }
        return articleVo;
    }

    @Autowired
     private ArticleBodyMapper articleBodyMapper;
    private ArticleBodyVo findArticleBodyById(Long bodyId) {
        ArticleBody articleBody=articleBodyMapper.selectById(bodyId);
        ArticleBodyVo articleBodyVo=new ArticleBodyVo();
        articleBodyVo.setContent(articleBody.getContent());
        return articleBodyVo;
    }

    @Override
    public Result hotArticle(int limit) {
        System.out.println("-------------"+limit+"--------------------");
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+limit);
        //select id,title from article order by view_counts desc limit 5
        List<Article> articles=articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles,false,false));
    }

    @Override
    public Result newArticles(int limit) {
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+limit);
        //select id,title from article order by create_date desc limit 5
        List<Article> articles=articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles,false,false));
    }

    @Override
    public Result listArchives() {
        List<Archives> archivesList=articleMapper.listArchives();
        return Result.success(archivesList);
    }

    @Autowired
    private ThreadService threadService;
    @Override
    public Result findArticleById(Long articleId) {
        Article article=this.articleMapper.selectById(articleId);
        ArticleVo articleVo=copy(article,true,true,true,true);
        //查看完文章阅读数加1，有没有问题？这时候做一个更新，更新时加写锁，阻塞其他读操作，性能低
        //更新增加此次接口耗时
        //可以将更新操作放入线程池，就与主线程无关了
        threadService.updateArticleViewCount(articleMapper,article);
        return Result.success(articleVo);
    }

    @Override
    public Result publish(ArticleParam articleParam) {
        return null;
    }
}
