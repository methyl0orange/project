package com.wxc.controller;


import com.wxc.common.Result;
import com.wxc.common.cache.Cache;
import com.wxc.common.webparams.PageParams;
import com.wxc.service.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("treasure")
public class TreasureController {
    @Autowired
    private TreasureService treasureService;

    @PostMapping("list")
    @Cache(expire = 4*60*1000,name = "treasurelist")
    public Result list(@RequestBody PageParams params){
        System.out.println("-----------------"+params.getPagenum());
        return treasureService.list(params.getPagenum());
    }

}
