package com.oracle.sport.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.sport.mapper.BrandMapper;
import com.oracle.sport.po.Brand;

import cn.itcast.common.page.Pagination;
import redis.clients.jedis.Jedis;
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;

	public Pagination selectBrands(String name,String isDisplay,Integer pageNo,Integer pageSize) {
		Brand brand = new Brand();
		if(name!=null&&!name.equals("")){
			brand.setName(name);
		}
		if(isDisplay!=null&&!isDisplay.equals("")){
			brand.setIsDisplay(isDisplay.equals("1")?true:false);
		}
		/*
		 * 分页开始
		 */
		
		if(pageSize!=null){
			brand.setSize(pageSize);
		}else{
			brand.setSize(3);
		}
		if(pageNo!=null){
			brand.setFromLine((pageNo-1)*brand.getSize());
		}else{
			brand.setFromLine(0);
			pageNo = 1;
		}
		
		List<Brand> brands = brandMapper.selectBrands(brand);
		
		Pagination pagination = new Pagination(pageNo, brand.getSize(),brandMapper.selectBrandcount(brand) ,brands);
		
		StringBuilder params = new StringBuilder();		
		
		params.append("size=3");
		
		if(name!=null&&!name.equals("")){
			params.append("&name="+name);
		}
		if(isDisplay!=null){
			params.append("&isDisplay="+isDisplay);
		}
		
		
		
		String url = "brandList.do";
		
		pagination.pageView(url, params.toString());
		
		
		
		
		return pagination;
	}

	public void deleteByPrimaryKey(Long id) {
		brandMapper.deleteByPrimaryKey(id);
		
	}

	public void deleteBrandsByIds(Long[] ids) {
		
		brandMapper.deleteBrandsByIds(ids);
		
	}
	/*@Autowired
	private Jedis jedis;
	public void saveBrand(Brand brand){
		brand.setId(jedis.incr("brandid"));
		brandMapper.insertSelective(brand);
	}*/


	public void insertSelective(Brand record) {
		
		brandMapper.insertSelective(record);
		
	}

	public Brand selectByPrimaryKey(Long id) {

        
		return brandMapper.selectByPrimaryKey(id);
	}

	public void updateByPrimaryKeySelective(Brand record) {
		brandMapper.updateByPrimaryKeySelective(record);
		
	}

	public List<Brand> selectAllBrand() {
		return brandMapper.selectAllBrand();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
