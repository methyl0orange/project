package com.oracle.cl.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * 
 * @author aqiu
 *
 */
import java.util.List;

import com.oracle.cl.po.Car;


public class CarDao {
    /**
     * 
     * @return 所有车辆信息
     */
	public List<Car> carList(Car car){
		List<Car> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");//jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
			String sql = "select * from car where 1=1 ";
			String name = car.getName();
			String pailiang = car.getPailiang();
			Integer jixiang = car.getJixiang();
			if(name!=null&&!"".equals(name)&&!"null".equals(name)){
				sql += " and name like '%"+name+"%'";
			}
			if(pailiang!=null&&!"".equals(pailiang)&&!"null".equals(pailiang)){
				sql += " and pailiang = "+pailiang;
			}
			if(jixiang!=null){
				sql += " and jixiang = "+jixiang;
			}
			sql+=" limit ?,?";
		    System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (car.getPageNo()-1)*car.getSize());
			ps.setInt(2, car.getSize());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Car c = new Car();
				c.setCarid(rs.getInt("carid"));
				c.setName(rs.getString("name"));
				c.setBirthday(rs.getDate("birthday"));
				c.setPailiang(rs.getString("pailiang"));
				c.setLeixing(rs.getString("leixing"));
				c.setRenshu(rs.getInt("renshu"));
				c.setJixiang(rs.getInt("jixiang"));
				c.setPrice(rs.getInt("price"));
				c.setImgurl(rs.getString("imgurl"));
				c.setState(rs.getString("state"));
				list.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//查询数据总数
	public int carCount(Car car){
		List<Car> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
			String sql = "select * from car where 1=1 ";
			String name = car.getName();
			String pailiang = car.getPailiang();
			Integer jixiang = car.getJixiang();
		
			if(name!=null&&!"".equals(name)&&!"null".equals(name)){
				sql += " and name like '%"+name+"%'";
			}
			if(pailiang!=null&&!"".equals(pailiang)&&!"null".equals(pailiang)){
				sql += " and pailiang = "+pailiang;
			}
			if(jixiang!=null){
				sql += " and jixiang = "+jixiang;
			}
			
		    System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Car c = new Car();
				c.setCarid(rs.getInt("carid"));
				c.setName(rs.getString("name"));
				c.setBirthday(rs.getDate("birthday"));
				c.setPailiang(rs.getString("pailiang"));
				c.setLeixing(rs.getString("leixing"));
				c.setRenshu(rs.getInt("renshu"));
				c.setJixiang(rs.getInt("jixiang"));
				c.setPrice(rs.getInt("price"));
				c.setImgurl(rs.getString("imgurl"));
				c.setState(rs.getString("state"));
				list.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.size();
	}
	//根据id删除数据
	public int carDelete(Integer carid){
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
			String sql = "delete from car where carid = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carid);
			
			i = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	//添加车辆
		public int carAdd(Car car){
			int i = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
				String sql = "insert into car(name,birthday,pailiang,leixing,renshu,jixiang,price,imgurl,state) values(?,?,?,?,?,?,?,?,?)";
			
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setObject(1, car.getName());
				ps.setObject(2, car.getBirthday());
				ps.setObject(3, car.getPailiang());
				ps.setObject(4, car.getLeixing());
				ps.setObject(5, car.getRenshu());
				ps.setObject(6, car.getJixiang());
				ps.setObject(7, car.getPrice());
				ps.setObject(8, car.getImgurl());
				ps.setObject(9, 0);
				
				
				i = ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		//更新
		//根据id删除数据
		public Car toUpdateCar(Integer carid){
			Car c  = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
				String sql = "select * from car where carid = ?";
			
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, carid);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					c = new Car();
					c.setCarid(rs.getInt("carid"));
					c.setName(rs.getString("name"));
					c.setBirthday(rs.getDate("birthday"));
					c.setPailiang(rs.getString("pailiang"));
					c.setLeixing(rs.getString("leixing"));
					c.setRenshu(rs.getInt("renshu"));
					c.setJixiang(rs.getInt("jixiang"));
					c.setPrice(rs.getInt("price"));
					c.setImgurl(rs.getString("imgurl"));
					c.setState(rs.getString("state"));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return c;
		}
		//更新
		public int carUpdate(Car car){
			int i = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
				String sql = "update car set name=?,birthday=?,pailiang=?,leixing=?,renshu=?,jixiang=?,price=?,imgurl=?,state=? where carid=?";
			
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setObject(1, car.getName());
				ps.setObject(2, car.getBirthday());
				ps.setObject(3, car.getPailiang());
				ps.setObject(4, car.getLeixing());
				ps.setObject(5, car.getRenshu());
				ps.setObject(6, car.getJixiang());
				ps.setObject(7, car.getPrice());
				ps.setObject(8, car.getImgurl());
				ps.setObject(9, car.getState());
				ps.setObject(10, car.getCarid());
				
				
				i = ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
}
