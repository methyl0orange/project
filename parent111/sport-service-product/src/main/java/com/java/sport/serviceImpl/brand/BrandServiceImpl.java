package com.java.sport.serviceImpl.brand;



import com.github.pagehelper.PageInfo;
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
     * 品牌查询，条件及分页
     * @param name
     * @param isDisplay
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    @Transactional
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
        if(pageSize != null) {
            brand.setSize(pageSize);
        }else {
            brand.setSize(3);
        }
        if(pageNo != null) {
            brand.setFromLine((pageNo-1)*brand.getSize());
        }else {
            brand.setFromLine(0);
            pageNo = 1;
        }

        System.out.println(name+"  "+isDisplay+"  "+brand.getFromLine()+"  "+brand.getSize());

        List<Brand> brandList = brandMapper.selectBrandsSelective(brand);

        System.out.println(brandMapper.selectBrandsCount(brand));

        System.out.println(brand.getName()+"  "+brand.getIsDisplay());

        PageInfo pagination = new PageInfo(pageNo,brand.getSize(),brandMapper.selectBrandsCount(brand),brandList);

        StringBuilder params = new StringBuilder();

        params.append("size=3");

        if(name != null && !name.equals("")) {
            params.append("&name="+name);
        }
        if(isDisplay != null) {
            params.append("&isDisplay="+isDisplay);
        }

        String url = "brandList.do";

        pagination.pageView(url,params.toString());

        return pagination;
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
