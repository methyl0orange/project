package com.java.sport.dao;

import com.github.pagehelper.PageInfo;
import com.java.sport.po.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectProductSelective(Product product);
}