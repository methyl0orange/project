package com.wxc.controller;


import com.wxc.common.Result;
import com.wxc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mine")
public class MineController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("buildinglist")
    public Result buildingList(){
        return buildingService.list();
    }

}
