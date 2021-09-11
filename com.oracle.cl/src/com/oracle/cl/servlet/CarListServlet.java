package com.oracle.cl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cl.po.Car;
import com.oracle.cl.service.CarService;

public class CarListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//���ܲ���
		String name = req.getParameter("name");
		String pailiang = req.getParameter("pailiang");
		String jixiang = req.getParameter("jixiang");
        Car car = new Car();
        car.setName(name);
        car.setPailiang(pailiang);
        car.setJixiang((jixiang!=null&&!"null".equals(jixiang)&&!"".equals(jixiang))?Integer.parseInt(jixiang):null);
		
        //���շ�ҳ����
        String pageNo = req.getParameter("pageNo");
        String size = req.getParameter("size");
       
        if(pageNo!=null&&!"".equals(pageNo)){
        	car.setPageNo(Integer.parseInt(pageNo));
        }else{
        	car.setPageNo(1);
        }
        if(size!=null&&!"".equals(size)){
        	car.setSize(Integer.parseInt(size));
        }else{
        	car.setSize(5);
        }
        
        
		req.setAttribute("clist", new CarService().carList(car));
		
	
		
		
		//ƴ�ӷ�ҳ��Ϣ
		String str = "<ul class='clearfix'>";
		if(car.getPageNo()!=1){
			str += "<li><a href='carList?pageNo=1&size=5&name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"'>��ҳ</a></li>";
			str += "<li><a href='carList?pageNo="+(car.getPageNo()-1)+"&size=5&name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"'>��ҳ</a></li>";
		}
		//��ȡ��������
		int count =  new CarService().carCount(car);
		int pages = 0;
		if(count%car.getSize()==0){
			pages = count/car.getSize();
		}else{
			pages = count/car.getSize()+1;
		}
		for(int i=1;i<=pages;i++){
			if(i==car.getPageNo()){
				str += "<li class='current'><a href='carList?pageNo="+i+"&size=5&name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"'>"+i+"</a></li>";
			}else{
				str += "<li><a href='carList?pageNo="+i+"&size=5&name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"'>"+i+"</a></li>";
			}
			
		}
		if(car.getPageNo()!=pages){
			str += "<li><a href='carList?pageNo="+(car.getPageNo()+1)+"&size=5&name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"'>��ҳ</a></li>";
			str += "<li><a href='carList?pageNo="+pages+"&size=5&name="+name+"&pailiang="+pailiang+"&jixiang="+jixiang+"'>βҳ</a></li>";
		}
		str += "<li class='pageinfo'>��"+pages+"ҳ</li>";
		
		str += "</ul>";
		
		
	    req.setAttribute("str", str);
		System.out.println(str);

		
		//����
		req.setAttribute("name", name);
		req.setAttribute("pailiang", pailiang);
		req.setAttribute("jixiang", jixiang);
		
		req.setAttribute("pageNo", car.getPageNo());
		req.setAttribute("size", car.getSize());
		
		req.getRequestDispatcher("content/institution-list.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
