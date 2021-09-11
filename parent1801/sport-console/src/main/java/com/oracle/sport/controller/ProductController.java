package com.oracle.sport.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.sport.brand.BrandService;
import com.oracle.sport.color.ColorService;
import com.oracle.sport.po.Product;
import com.oracle.sport.product.ProductService;
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ColorService colorService;
	
	@RequestMapping("productList.do")
	public String productList(Model model,Product product){
		System.out.println(product);
		model.addAttribute("pagination", productService.selectProducts(product));
		model.addAttribute("blist", brandService.selectAllBrand());
		model.addAttribute("product", product);
		return "product/list";
	}
	//删除
	@RequestMapping("deleteProduct.do")
	public String deleteProduct(Model model,Product product){
		
		productService.deleteById(product.getId());
		
		String url = null;
		try {
			url = "redirect:productList.do?name="+URLEncoder.encode(product.getName(),"utf-8")+"&isShow="+product.getIsShow()+"&brandId="+product.getBrandId()+"&pageNo="+product.getPageNo();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	//批量删除
	@RequestMapping("deleteProducts.do")
	public String deleteProducts(Long[] ids){
			
		productService.deleteByIds(ids);
			
		return "redirect:productList.do";
	}
	//批量上架
	@RequestMapping("groundingProducts.do")
	public String groundingProducts(Long[] ids){
		
		productService.groundingByIds(ids);
			
		return "redirect:productList.do";
	}
	//批量下架
	@RequestMapping("undercarriageProducts.do")
	public String undercarriageProducts(Long[] ids){
		
		productService.undercarriageByIds(ids);
				
		return "redirect:productList.do";
	}
	//商品添加
	@RequestMapping("toProductAdd.do")
	public String toProductAdd(Model model){
		//
		model.addAttribute("brands", brandService.selectAllBrand());
		model.addAttribute("colors", colorService.selectAllColor());
		return "product/add";
	}
	//上传多张图片
	@ResponseBody
	@RequestMapping("productLoad.do")
	public List<String> productLoad(@RequestParam(required = false)MultipartFile[] pics,HttpSession session ){
		String path = session.getServletContext().getRealPath("upload");
		List<String> list = new ArrayList<String>();
		for(MultipartFile pic:pics){
			try {
				pic.transferTo(new File(path+File.separator+pic.getOriginalFilename()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add("http://localhost:8081/upload/"+pic.getOriginalFilename());
		}
		
		return list;
	}
	
	//添加
	@RequestMapping("productAdd.do")
	public String productAdd(Product product){
		
		productService.insertSelective(product);
		
		return "redirect:productList.do";
		
	}
	
	
	
	
}
