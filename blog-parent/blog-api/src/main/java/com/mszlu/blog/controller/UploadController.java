package com.mszlu.blog.controller;


import com.mszlu.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {
    @PostMapping
    public Result upload(@RequestParam("image")MultipartFile file){
        //原始文件名称 比如 aa.png
        String originalFilename=file.getOriginalFilename();
        //唯一的文件名称
        String filename=UUID.randomUUID().toString()+"."+ StringUtils.substringAfterLast(originalFilename,".");

        //上传到哪呢  云服务器
        return null;
    }
}
