package com.java.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品
 */

@Controller
public class ProductController {


    @RequestMapping("productList.do")
    public String productList() {
        return "product/list";
    }


}
