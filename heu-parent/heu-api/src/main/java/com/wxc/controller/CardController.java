package com.wxc.controller;

import com.wxc.common.Result;
import com.wxc.common.cache.Cache;
import com.wxc.common.webparams.PageParams;
import com.wxc.service.InformService;
import com.wxc.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    private InformService informService;
    @PostMapping("inform")
    public Result informList(){
        return informService.list();
    }

    @Autowired
    private CardService cardService;

    @PostMapping("cardlist")
    @Cache(expire = 3*60*1000,name = "cardlist")
    public Result cardList(@RequestBody PageParams params){return cardService.cardList(params.getPagenum());}
}
