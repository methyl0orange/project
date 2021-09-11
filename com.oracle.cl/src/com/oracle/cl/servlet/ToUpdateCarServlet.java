package com.oracle.cl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cl.po.Car;
import com.oracle.cl.service.CarService;
/**
 * 
 * @author aqiu
 * 内部转发。去添加页
 */
public class ToUpdateCarServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carid = req.getParameter("carid");
		req.setAttribute("car", new CarService().toCarUpdate(Integer.parseInt(carid)));
		
		
        req.getRequestDispatcher("content/institution-edit.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
