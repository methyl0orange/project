package com.java.sport.service.brand;

import com.java.sport.po.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    Brand selectByPrimaryKey(Long id);

    void deleteBrandByPrimaryKey(Long id);

    void deleteBrandsById(Long[] ids);

}
