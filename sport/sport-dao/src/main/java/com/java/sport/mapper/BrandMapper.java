package com.java.sport.mapper;

import com.java.sport.po.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectBrands();
}