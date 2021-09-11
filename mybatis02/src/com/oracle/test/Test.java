package com.oracle.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.oracle.po.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oracle.dao.CarMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession(true);
		int i = session.getMapper(CarMapper.class).deleteByPrimaryKey(5);
//		System.out.println(session.getMapper(CarMapper.class).selectCars().size());
//		System.out.println(i);
//		List<Car> clist=session.getMapper(CarMapper.class).selectCars();
//		System.out.println(clist);
//		Car car=session.getMapper(CarMapper.class).selectByPrimaryKey(2);
		System.out.println(i);
	}

}
