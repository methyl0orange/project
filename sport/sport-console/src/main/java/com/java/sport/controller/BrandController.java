package com.java.sport.controller;

import com.java.sport.service.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("index.do")
    public String selectBrands(Model model){
        model.addAttribute("blist",brandService.selectBrands());
        System.out.println(brandService.selectBrands().size());
        return "index";
    }
}
