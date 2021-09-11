package com.java.sport.dao;

import com.java.sport.po.Sku;

public interface SkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}