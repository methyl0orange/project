package com.oracle.ssm.controller;

import com.oracle.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("selectStudents")
    public String selectStudents(Model model){
        model.addAttribute("slist",studentService.selectStudents());
        System.out.println(studentService.selectStudents().size());
        return "index";
    }

    @RequestMapping("delete")
    public String deleteByPrimaryKey(Integer id){
        studentService.deleteByPrimaryKey(id);
        return "redirect:selectStudents";
    }
}
