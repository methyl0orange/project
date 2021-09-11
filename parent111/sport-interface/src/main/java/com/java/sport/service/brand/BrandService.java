package com.java.sport.service.brand;

import com.github.pagehelper.Page;
import com.java.sport.po.Brand;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    Brand selectByPrimaryKey(Long id);

    PageInfo selectBrandsSelective(String name, String isDisplay, Integer pageNo, Integer pageSize);

    void deleteBrandByPrimaryKey(Long id);

    void deleteBrandsById(Long[] ids);
}
