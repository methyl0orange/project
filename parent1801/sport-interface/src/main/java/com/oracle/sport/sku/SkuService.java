package com.oracle.sport.sku;

import java.util.List;

import com.oracle.sport.po.Sku;

public interface SkuService {

	public List<Sku> selectByProductId(Long productId);
	
	public Sku selectByPrimaryKey(Long id);
}
