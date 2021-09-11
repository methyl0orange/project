package com.java.sport.serviceImpl.brand;

import com.java.sport.mapper.BrandMapper;
import com.java.sport.po.Brand;
import com.java.sport.service.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public Brand selectByPrimaryKey(Long id) {
        System.out.println("成功啦！");
        return brandMapper.selectByPrimaryKey(id);
    }



    /**
     * 根据品牌id值软删除
     * @param id
     */
    @Override
    public void deleteBrandByPrimaryKey(Long id) {
        brandMapper.deleteBrandByPrimaryKey(id);
    }

    @Override
    public void deleteBrandsById(Long[] ids) {
        brandMapper.deleteBrandsById(ids);
    }

}
