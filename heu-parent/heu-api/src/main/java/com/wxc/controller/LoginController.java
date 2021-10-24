package com.wxc.controller;

import com.wxc.common.Result;
import com.wxc.common.webparams.WXcode;
import com.wxc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("openid")
    public Result OpenId(@RequestBody WXcode wXcode){
        System.out.println(wXcode);

        return loginService.GetAppId(wXcode.getCode());
    }

}
