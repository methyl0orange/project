package com.java.sport.service;

import com.github.pagehelper.PageInfo;
import com.java.sport.po.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    Brand selectByPrimaryKey(Long id);

    PageInfo selectBrandsSelective(String name, String isDisplay, Integer pageNo, Integer pageSize);

    void deleteBrandByPrimaryKey(Long id);

    void deleteBrandsById(Long[] ids);

    List<Brand> selectBrands();

    int updateByPrimaryKeySelective(Brand brand);
}
