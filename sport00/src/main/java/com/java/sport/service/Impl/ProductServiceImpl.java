package com.java.sport.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.sport.dao.ProductMapper;
import com.java.sport.po.Brand;
import com.java.sport.po.Product;
import com.java.sport.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    public int insert(Product record) {
        return productMapper.insert(record);
    }

    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    public PageInfo selectProductSelective(Integer brandId,String name, String isShow, Integer pageNo, Integer pageSize) {

        Product product1 = new Product();
        //处理参数
        if(name != null && !name.equals("")) {
            product1.setName(name);
        }
        if(brandId != null && !brandId.equals("")) {
            product1.setBrandId(brandId);
        }
        if(isShow != null && !isShow.equals("")) {
            product1.setIsShow(isShow.equals("1")?true:false);
        }
        //分页
        if(pageSize!=null) {

        }else {
            pageSize=8;
        }
        if(pageNo != null) {

        }else {
            pageNo = 1;
        }

        PageHelper.startPage(pageNo,pageSize);

        List<Product> productList = productMapper.selectProductSelective(product1);

        System.out.println(productMapper.selectProductSelective(product1).size());

        PageInfo<Product> pagination = new PageInfo<Product> (productList);



        return pagination;
    }
}
