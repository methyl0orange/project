package com.java.sport.service.brand;

import com.java.sport.po.Brand;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface BrandService {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectBrands();
}
