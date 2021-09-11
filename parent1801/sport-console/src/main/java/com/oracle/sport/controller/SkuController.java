package com.oracle.sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.sport.sku.SkuService;

@Controller
public class SkuController {

	@Autowired
	private SkuService skuService;
	
	@RequestMapping("skuList.do")
	public String selectSkusByProductId(Model model ,Long productId){
		model.addAttribute("skus", skuService.selectByProductId(productId));
		return "sku/list";
	}
}
