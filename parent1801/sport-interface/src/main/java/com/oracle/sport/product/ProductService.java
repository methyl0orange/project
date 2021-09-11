package com.oracle.sport.product;


import com.oracle.sport.po.Product;

import cn.itcast.common.page.Pagination;

public interface ProductService {

    public Pagination selectProducts(Product record);
    
    public void deleteById(Long id);
    
    public void deleteByIds(Long[] ids);
    
    public void groundingByIds(Long[] ids);
    
    public void undercarriageByIds(Long[] ids);
    
    public void insertSelective(Product record) ;
}
