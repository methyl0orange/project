package com.oracle.sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.sport.solr.ProductSolrService;

@Controller
public class ProductSolrController {

	@Autowired
	private ProductSolrService productSolrService;
	
	@RequestMapping("Search")
	public String search(Model model,String keyword, Integer pageNo, Integer pageSize){
		model.addAttribute("pagination", productSolrService.selectProductsSolr(keyword, pageNo, pageSize));
		return "search";
	}
}
