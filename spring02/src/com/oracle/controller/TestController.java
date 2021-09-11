package com.oracle.controller;

import com.google.gson.Gson;
import com.oracle.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/user")
//@SessionAttributes(value ="name",types = {java.lang.String.class})
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "index";
    }

    @RequestMapping("/log")
    public String login(User user, Model model){
        System.out.println(user);
        model.addAttribute("name",user.getUsername());
        return"log2";
    }

   /* @RequestMapping("/myjson")
    public void myjson(Writer writer){
        List<User> ulist=new ArrayList<>();
        ulist.add(new User("asd","asd"));
        ulist.add(new User("qqq","123"));

        Gson gson=new Gson();
        String str=gson.toJson(ulist);
        try {
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @RequestMapping("/myjson")
    @ResponseBody
    public List<User> myjson(){
        List<User> ulist=new ArrayList<>();
        ulist.add(new User("asd","asd"));
        ulist.add(new User("qqq","123"));
//少jackson.jar包
        return ulist;
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile myfile, HttpSession session){

        String path=session.getServletContext().getRealPath("upload");
        System.out.println(path);
        try {
            myfile.transferTo(new File(path+File.separator+myfile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
