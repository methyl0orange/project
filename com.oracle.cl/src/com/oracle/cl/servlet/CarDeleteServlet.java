package com.oracle.cl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cl.po.Car;
import com.oracle.cl.service.CarService;

public class CarDeleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接受参数
		String name = req.getParameter("name");
		String pailiang = req.getParameter("pailiang");
		String jixiang = req.getParameter("jixiang");
        String pageNo = req.getParameter("pageNo");
        String size = req.getParameter("size");
        String carid = req.getParameter("carid");
		
        new CarService().carDelete(Integer.parseInt(carid));
        
        //成功后重新查询
        resp.sendRedirect("carList?name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"&pageNo="+pageNo+"&size="+size);
       
		
  
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
