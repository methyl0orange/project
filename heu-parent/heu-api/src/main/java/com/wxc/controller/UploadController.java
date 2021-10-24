package com.wxc.controller;


import com.wxc.common.Result;
import com.wxc.service.BuildingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {

    @PostMapping("image")
    private Result image(@RequestParam("image")MultipartFile file){
        String originalFilename=file.getOriginalFilename();
        //唯一的文件名称
        String fileName=UUID.randomUUID().toString()+"."+ StringUtils.substringAfterLast(originalFilename,".");
        return null;
    }



    @Autowired
    private BuildingService buildingService;

    @PostMapping("getnoimgbuildinglist")
    private Result getNoImgBuildingList(){
        return buildingService.notImgList();
    }
    @PostMapping("treasure")
    public Result treasure(){
        return null;
    }

}
