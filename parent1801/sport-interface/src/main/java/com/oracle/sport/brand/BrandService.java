package com.oracle.sport.brand;


import java.util.List;

import com.oracle.sport.po.Brand;

import cn.itcast.common.page.Pagination;

public interface BrandService {

	public Pagination selectBrands(String name,String isDisplay,Integer pageNo,Integer pageSize);
	
	public void deleteByPrimaryKey(Long id);
	
	public void deleteBrandsByIds(Long[] ids);
	
	public void insertSelective(Brand record);
	
	public Brand selectByPrimaryKey(Long id);
	
	public void updateByPrimaryKeySelective(Brand record);
	
	public List<Brand> selectAllBrand();
}
