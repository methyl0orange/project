package com.java.sport.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.sport.dao.BrandMapper;
import com.java.sport.po.Brand;
import com.java.sport.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;


    public Brand selectByPrimaryKey(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public PageInfo selectBrandsSelective(String name, String isDisplay, Integer pageNo, Integer pageSize) {
        Brand brand = new Brand();
        //处理参数
        if(name != null && !name.equals("")) {
            brand.setName(name);
        }
        if(isDisplay != null && !isDisplay.equals("")) {
            brand.setIsDisplay(isDisplay.equals("1")?true:false);
        }
        //分页
        if(pageSize!=null) {

        }else {
            pageSize=4;
        }
        if(pageNo != null) {

        }else {
            pageNo = 1;
        }

        PageHelper.startPage(pageNo,pageSize);

        List<Brand> brandList = brandMapper.selectBrandsSelective(brand);

        System.out.println(brandMapper.selectBrandsCount(brand));

        System.out.println(brandMapper.selectBrandsSelective(brand).size());

        PageInfo<Brand> pagination = new PageInfo<Brand> (brandList);


        return pagination;
    }

    public void deleteBrandByPrimaryKey(Long id) {

        brandMapper.deleteByPrimaryKey(id);
    }

    public void deleteBrandsById(Long[] ids) {

        brandMapper.deleteBrandsById(ids);
    }

    public List<Brand> selectBrands() {
        Brand brand1=new Brand();
        return brandMapper.selectBrandsSelective(brand1);
    }

    public int updateByPrimaryKeySelective(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }
}
