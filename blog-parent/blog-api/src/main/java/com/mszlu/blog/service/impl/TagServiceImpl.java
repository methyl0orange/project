package com.mszlu.blog.service.impl;

import com.mszlu.blog.dao.mapper.TagMapper;
import com.mszlu.blog.dao.pojo.Tag;
import com.mszlu.blog.service.TagService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    public TagVo copy(Tag tag){
        TagVo tagVo=new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList=new ArrayList<>();
        for(Tag tag:tagList){
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticledId(Long articleId) {
        //mybatisplus无法进行多表查询
        List<Tag> tags=tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /*
        *1.标签所拥有的文章数量最多
        * 2.查询根据tag_id分组计数，从大到小排列取前limit个
         */
        List<Long> tagsIds=tagMapper.findHotsTagIds(limit);
        //需求的是tag_id和tagName Tag 对象
        if(CollectionUtils.isEmpty(tagsIds)){
            return Result.success(Collections.emptyList());
        }
        List<Tag> tagList=tagMapper.findTagsByTagIds(tagsIds);
        return Result.success(tagList);
    }
}
