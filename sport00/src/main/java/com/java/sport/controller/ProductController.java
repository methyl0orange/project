package com.java.sport.controller;

import com.github.pagehelper.PageInfo;
import com.java.sport.po.Brand;
import com.java.sport.po.Product;
import com.java.sport.service.BrandService;
import com.java.sport.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("productList.do")
    public String productList(Model model,String name, String isShow, Integer pageNo, Integer pageSize,Integer brandId) {
        System.out.println("pageNo   :"+pageNo);
        System.out.println("productName   :"+name);
        System.out.println("productId   :"+brandId);
        System.out.println("pageSize   :"+pageSize);
        PageInfo<Product> pageInfo=productService.selectProductSelective(brandId,name,isShow,pageNo,pageSize);
        List<Brand> brandList=brandService.selectBrands();
        model.addAttribute("page",pageInfo);
        model.addAttribute("brandList",brandList);
        return "product/list";
    }


}
