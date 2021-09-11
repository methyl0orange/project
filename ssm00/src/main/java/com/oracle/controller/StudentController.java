package com.oracle.controller;

import com.oracle.po.Student;
import com.oracle.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/selectStudents")
    public String selectStudents(Model model){
        model.addAttribute("slist",studentService.selectAll());
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        studentService.deleteByPrimaryKey(id);
        return "show";
    }
    @RequestMapping("/insert")
    public String insert(Student student){
        studentService.insert(student);
        return "redirect:selectStudents";
    }
    @RequestMapping("/selectStudentById")
    public String selectStudentById(Integer id,Model model){
        model.addAttribute("Student",studentService.selectByPrimaryKey(id));
        return "update";
    }

    @RequestMapping("/update")
    public String update(Student student){

        studentService.updateByPrimaryKeySelective(student);
        return "redirect:selectStudents";
    }
}
