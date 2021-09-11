package com.java.sport.service;


import com.github.pagehelper.PageInfo;
import com.java.sport.po.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    PageInfo selectProductSelective(Integer brandId,String name, String isShow, Integer pageNo, Integer pageSize);
}
