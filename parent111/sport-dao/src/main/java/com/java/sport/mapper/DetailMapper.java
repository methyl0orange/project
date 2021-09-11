package com.java.sport.mapper;

import com.java.sport.po.Detail;

public interface DetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Detail record);

    int insertSelective(Detail record);

    Detail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
}