package com.oracle.sport.sku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sport.mapper.SkuMapper;
import com.oracle.sport.po.Sku;

@Service("skuService")
public class SkuServiceImpl implements SkuService {

	@Autowired
	private SkuMapper skuMapper;
	
	public List<Sku> selectByProductId(Long productId) {
		
		return skuMapper.selectByProductId(productId);
	}

	public Sku selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return skuMapper.selectByPrimaryKey(id);
	}

}
