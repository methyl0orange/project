package com.java.sport.controller;

import com.java.sport.po.Brand;
import com.java.sport.service.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class Test {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/test.do")
    public String selectByPrimaryKey() {

        Brand brand = brandService.selectByPrimaryKey(1L);

        System.out.println(brand);

        System.out.println(brand.getName());
        return "index";
    }

}
