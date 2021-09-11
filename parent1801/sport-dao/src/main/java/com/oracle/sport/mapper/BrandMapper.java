package com.oracle.sport.mapper;

import java.util.List;

import com.oracle.sport.po.Brand;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
    
    List<Brand> selectBrands(Brand brand);
    
    int selectBrandcount(Brand brand);
    
    int deleteBrandsByIds(Long[] ids);
    
    List<Brand> selectAllBrand();
}