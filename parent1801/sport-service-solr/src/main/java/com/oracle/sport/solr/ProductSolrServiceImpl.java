package com.oracle.sport.solr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sport.po.Product;

import cn.itcast.common.page.Pagination;

@Service("productSolrService")
public class ProductSolrServiceImpl implements ProductSolrService{

	@Autowired
	private HttpSolrServer solrServer;
	
	public Pagination selectProductsSolr(String keyword, Integer pageNo, Integer pageSize) {
	    
		if(pageNo==null){
			pageNo = 1;
		}
		if(pageSize==null){
			pageSize = 24;
		}
		
		
		
	    //拼接条件
	    StringBuilder params = new StringBuilder();
	    
		List<Product> products = new ArrayList<Product>();
		SolrQuery solrQuery = new SolrQuery();
		//关键词，设置查询条件
		solrQuery.set("q", "name_ik:" + keyword);  //name_ik:男士休闲运动超短裙
		params.append("keyword=").append(keyword);
		//过滤条件
		/*if(null != brandId){
			solrQuery.addFilterQuery("brandId:" + brandId);
			params.append("&brandId="+brandId);
		}
		//价格   0-99 1600 
		if(null != priceStr){
			String[] p = priceStr.split("-");
			if(p.length == 2){
				solrQuery.addFilterQuery("price:[" + p[0] + " TO " + p[1] + "]");
			}else{
				solrQuery.addFilterQuery("price:[" + p[0] + " TO *]");
			}
			params.append("&priceStr="+priceStr);
		}*/
		//高亮
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("name_ik");
		// 样式  <span style='color:red'>2016</span>
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		solrQuery.setHighlightSimplePost("</span>");
		//排序
		solrQuery.addSort("price", ORDER.asc);
		//分页  limit 开始行 ， 每页显示条数
//		solrQuery.setStart(pageNo);
//		solrQuery.setRows(pageSize);
		//分页  limit 开始行 ， 每页显示条数
		solrQuery.setStart((pageNo-1)*pageSize);
		solrQuery.setRows(pageSize);
		//执行查询
		QueryResponse response = null;
		try {
			response = solrServer.query(solrQuery);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//取高亮
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		// Map K : V    442 : Map
		// Map K : V    name_ik : List<String>
		// List<String> list   2016年最新款191期卖的瑜伽服最新限量纯手工制作细心打造商户经典买一送一清 list.get(0);
		//结果集
		SolrDocumentList docs = response.getResults();
		//发现的条数 （总条件）构建分页时用到
		long numFound = docs.getNumFound();
		for (SolrDocument doc : docs) {
			//创建商品对象
			Product product2 = new Product();
			//商品ID 
			String id = (String) doc.get("id");
			product2.setId(Long.parseLong(id));
			//商品名称  ik
			Map<String, List<String>> map = highlighting.get(id);
			List<String> list = map.get("name_ik");
			product2.setName(list.get(0));
		/*	String name = (String) doc.get("name_ik");
			product.setName(name);*/
			//图片
			String imgUrl = (String) doc.get("imgUrl");
			product2.setImgUrl(imgUrl.split(",")[0]);//img,img2,img3
			product2.setImgUrls(imgUrl.split(","));
			//价格 售价   select price from bbs_sku where product_id =442 order by price asc limit 0,1
			product2.setPrice((Float) doc.get("price"));
			
			products.add(product2);
		}
		//构建分页对象
		Pagination pagination = new Pagination(
				pageNo,
				pageSize,
				(int)numFound,
				products
				);
		//页面展示
		String url = "/Search";
		pagination.pageView(url, params.toString());
		
		return pagination;
	}

}
