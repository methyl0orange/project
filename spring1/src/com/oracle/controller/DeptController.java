package com.oracle.controller;

import com.oracle.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("index")
    public String controller(){
        deptService.service();
        return "success";
    }
}
