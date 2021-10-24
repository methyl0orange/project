package com.wxc.controller;

import com.wxc.common.Result;
import com.wxc.common.webparams.TreasureParams;
import com.wxc.service.GetAndUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("my")
public class GetAndUploadController {
    @Autowired
    private GetAndUploadService getAndUploadService;

    @PostMapping("card")
    public Result myCard(@RequestBody TreasureParams params){
        return getAndUploadService.lookCardById(params.getId().toString());
    }
    @PostMapping("treasure")
    public Result myTreasure(@RequestBody TreasureParams params){
        return getAndUploadService.lookTreasureById(params.getId());
    }
    @PostMapping("gettreasure")
    public Result getTreasure(@RequestHeader("Authorization")String token,@RequestBody TreasureParams params){
        System.out.println(token+"-----------------getTreasure"+params.getId());

        return getAndUploadService.getTreasure(token,params.getId());
    }
    @PostMapping("getcard")
    public Result getCard(@RequestHeader("Authorization")String token,@RequestBody TreasureParams params){
        System.out.println(token+"getcard"+params.getId().toString());
        return  getAndUploadService.getCard(token,params.getId().toString());
    }
}
