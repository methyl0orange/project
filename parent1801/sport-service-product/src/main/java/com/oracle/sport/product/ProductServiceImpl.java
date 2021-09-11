package com.oracle.sport.product;


import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sport.commons.Array2String;
import com.oracle.sport.mapper.BrandMapper;
import com.oracle.sport.mapper.ColorMapper;
import com.oracle.sport.mapper.ProductMapper;
import com.oracle.sport.mapper.SkuMapper;
import com.oracle.sport.po.Color;
import com.oracle.sport.po.Product;
import com.oracle.sport.po.Sku;
import com.oracle.sport.staticpage.StaticPageServiceImpl;

import cn.itcast.common.page.Pagination;
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	
	public Pagination selectProducts(Product record) {
		//System.out.println("---------"+record);
		
			if(record.getName()!=null&&"".equals(record.getName())){
				record.setName(null);
			}
			if(record.getBrandId()!=null&&record.getBrandId()==0){
				record.setBrandId(null);
			}
			if(record.getIsShow()!=null&&record.getIsShow()==2){
				record.setIsShow(null);
			}
			if(record.getSize()==null||record.getSize().equals("")){
				record.setSize(8);
			}
			if(record.getPageNo()==null||record.getPageNo().equals("")){
				record.setPageNo(1);
			}
	
		
		record.setFromLine((record.getPageNo()-1)*record.getSize());
		
		List<Product> plist = productMapper.selectProducts(record);
		for (Product product : plist) {
			product.setImgUrls(product.getImgUrl().split(","));
		}
		
		Pagination pagination = new Pagination(record.getPageNo(), record.getSize(), productMapper.selectProductcount(record), plist);
		
        StringBuilder params = new StringBuilder();		
		
		params.append("size=8");
		
		if(record.getName()!=null){
			params.append("&name="+record.getName());
		}
		if(record.getBrandId()!=null){
			params.append("&brandId="+record.getBrandId());
		}
		if(record.getIsShow()!=null){
			params.append("&isShow="+record.getIsShow());
		}
		
		String url = "productList.do";
		
		pagination.pageView(url, params.toString());
		
		
		return pagination;
	}


	public void deleteById(Long id) {
		productMapper.deleteById(id);
	}


	public void deleteByIds(Long[] ids) {
		productMapper.deleteByIds(ids);
	}

//上架
	@Autowired
	private HttpSolrServer solrServer;
	@Autowired
	private SkuMapper skuMapper;
	@Autowired
	private StaticPageServiceImpl staticPageService;
	@Autowired
	private ColorMapper colorMapper;
	public void groundingByIds(Long[] ids) {
		productMapper.groundingByIds(ids);
		//向solr中存入数据
		addSolr(ids);
		//静态化
		for(Long id:ids){
			Map<String, Object>  root = new HashMap<String, Object>();
			
			List<Sku> skus = skuMapper.selectByProductId(id);
	
			float minPrice = skuMapper.selectMinPriceByProductId(id);
			
			Product product = productMapper.selectByPrimaryKey(id);
			product.setPrice(minPrice);
			product.setImgUrls(product.getImgUrl().split(","));
			//遍历一次  相同不要
			Set<Color> colors = new HashSet<Color>();
			for (Sku sku : skus) {
				colors.add(colorMapper.selectByPrimaryKey(sku.getColorId()));
			}
			root.put("product", product);
			root.put("skus", skus);
			root.put("colors", colors);
			staticPageService.productStaticPage(root, String.valueOf(id));
		}
		
		
	}


	public void undercarriageByIds(Long[] ids) {
		productMapper.undercarriageByIds(ids);
	}


	public void insertSelective(Product record) {
		
		
		record.setImgUrl(Array2String.array2String(record.getImgUrls()));
		record.setColors(Array2String.array2String(record.getColorss()));
		record.setSizes(Array2String.array2String(record.getSizess()));
		record.setIsDel(1);
		record.setIsShow(0);
		productMapper.insertSelective(record);
		
		
	}

	private void addSolr(Long[] ids){
		
		for(Long id:ids){
			SolrInputDocument sid = new SolrInputDocument();
			sid.addField("id", id);
			Product product = productMapper.selectByPrimaryKey(id);
			sid.addField("brandId", product.getBrandId());
			sid.addField("name_ik", product.getName());
			sid.addField("imgUrl", product.getImgUrl());
			sid.addField("price", skuMapper.selectMinPriceByProductId(id));
			try {
				solrServer.add(sid);
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				solrServer.commit();
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	//静态化
	

}
