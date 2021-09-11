package com.oracle.controller;

import com.oracle.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "index";
    }
    @RequestMapping("/login")
    public String login( User user){

        System.out.println(user);
        return "index";
    }
}
