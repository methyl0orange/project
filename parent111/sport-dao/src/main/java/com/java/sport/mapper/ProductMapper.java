package com.java.sport.mapper;

import com.java.sport.po.Product;
import com.java.sport.po.ProductWithBLOBs;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductWithBLOBs record);

    int insertSelective(ProductWithBLOBs record);

    ProductWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    int updateByPrimaryKey(Product record);
}