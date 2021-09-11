package com.java.sport.serviceImpl;

import com.java.sport.mapper.BrandMapper;
import com.java.sport.po.Brand;
import com.java.sport.service.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public int deleteByPrimaryKey(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    public int insertSelective(Brand record) {
        return brandMapper.insertSelective(record);
    }

    public Brand selectByPrimaryKey(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Brand record) {
        return brandMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Brand record) {
        return updateByPrimaryKey(record);
    }

    public List<Brand> selectBrands() {
        return brandMapper.selectBrands();
    }
}
