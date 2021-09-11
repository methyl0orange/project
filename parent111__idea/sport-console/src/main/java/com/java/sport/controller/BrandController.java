package com.java.sport.controller;

import com.java.sport.service.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 品牌
 */
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 根据id删除品牌
     * @param id
     * @param name
     * @param isDisplay
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("deleteBrand.do")
    public String deleteBrand(Long id, String name, String isDisplay, Integer pageNo, Integer pageSize) {
        System.out.println("delete:"+isDisplay+"   pageNo:"+pageNo+"   pageSize"+pageSize);
        brandService.deleteBrandByPrimaryKey(id);
        return "redirect:brandList.do?pageNo="+pageNo+"&pageSize="+pageSize+"&name="+name+"&isDisplay="+isDisplay;
    }

    /**
     * 根据ids软删除
     * @param ids
     * @param name
     * @param isDisplay
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("deleteBrands.do")
    public String deleteBrands(Long[] ids, String name, String isDisplay, Integer pageNo, Integer pageSize) {
        System.out.println("deleteBrands");
        brandService.deleteBrandsById(ids);
        return "redirect:brandList.do?pageNo="+pageNo+"&pageSize="+pageSize+"&name="+name+"&isDisplay="+isDisplay;
    }



}
