package com.oracle.mymvc;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.servlet.Person;

public class MyMVC extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		MyMVCXMLManger mm = null;
		try {
			mm = new MyMVCXMLManger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,ClassMethod> map = mm.getMap();
		
		String[] uris = uri.split("/");
		ClassMethod cm = map.get(uris[uris.length-1]);
		
		try {
			Class clazz = Class.forName(cm.getClassName());
			
			
			
			
			//---------------------参数处理--------------------
			
			  Enumeration<String> es = req.getParameterNames();
			
			  Object obj1 = Person.class.newInstance();
			  
			  while(es.hasMoreElements()){
				  String name = es.nextElement();
				  String s = req.getParameter(name);
				  String setStr = "set"+Character.toUpperCase(name.charAt(0))+name.substring(1);
				  System.out.println(Person.class.getDeclaredField(name).getType());
				  if("String".equals(Person.class.getDeclaredField(name).getType().getSimpleName())){
					  Person.class.getMethod(setStr, Person.class.getDeclaredField(name).getType()).invoke(obj1, s);
				  }else{
					  Person.class.getMethod(setStr, Person.class.getDeclaredField(name).getType()).invoke(obj1, Integer.parseInt(s));
				  }
				  
			  }
			  

			
			//---------------------参数处理--------------------
			Method method = clazz.getMethod(cm.getMethodName(),Person.class);
			String pageName =String.valueOf(method.invoke(clazz.newInstance(),obj1)) ;
			
			req.getRequestDispatcher(pageName+".jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
