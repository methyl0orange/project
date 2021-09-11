package com.java.sport.dao;

import com.java.sport.po.Brand;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    int selectBrandsCount(Brand record);

    List<Brand> selectBrandsSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int deleteBrandByPrimaryKey(Long id);

    int deleteBrandsById(Long[] ids);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}