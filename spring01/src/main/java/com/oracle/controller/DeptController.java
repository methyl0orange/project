package com.oracle.controller;

import com.oracle.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;
    public String controller(){
        deptService.service();
        return "success";
    }
}
