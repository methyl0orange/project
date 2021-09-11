package com.java.sport.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.sport.po.Brand;
import com.java.sport.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("brandList.do")
    public String selectBrands(Model model,String name, String isDisplay, Integer pageNo, Integer pageSize){
        PageInfo<Brand> pageInfo=brandService.selectBrandsSelective(name,isDisplay,pageNo,pageSize);
        model.addAttribute("pagination",pageInfo);
        return "brand/list";
    }

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

    //图片上传
    @ResponseBody
    @RequestMapping("upload.do")
    public  String upload(MultipartFile file, HttpSession session){
        String path=session.getServletContext().getRealPath("upload");
        try {
            file.transferTo(new File(path+File.separator+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:8080/upload/"+file.getOriginalFilename();
    }

}
