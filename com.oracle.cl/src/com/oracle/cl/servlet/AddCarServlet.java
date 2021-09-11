package com.oracle.cl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cl.po.Car;
import com.oracle.cl.service.CarService;
/**
 * 
 * @author aqiu
 * 添加页
 */
public class AddCarServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接受参数
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String pailiang = req.getParameter("pailiang");
		String leixing = req.getParameter("leixing");
		String renshu = req.getParameter("renshu");
		String jixiang = req.getParameter("jixiang");
		String price = req.getParameter("price");
		String imgurl = req.getParameter("imgurl");
		
		/*System.out.println(name);
		System.out.println(birthday);
		System.out.println(pailiang);
		System.out.println(leixing);
		System.out.println(renshu);
		System.out.println(jixiang);
		System.out.println(price);
		System.out.println(imgurl);
		*/
		
		//图片上传（使用流）
		
		//把接收到的参数，封装到对象中
		Car car = new Car();
		car.setName(name);	
		try {
			car.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		car.setPailiang(pailiang);
		car.setLeixing(leixing);
		car.setRenshu(Integer.parseInt(renshu));
		car.setJixiang(Integer.parseInt(jixiang));
		car.setPrice(Integer.parseInt(price));
		car.setImgurl(imgurl);
		
		CarService carService = new CarService();
		carService.carAdd(car);
		resp.sendRedirect("carList");
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
