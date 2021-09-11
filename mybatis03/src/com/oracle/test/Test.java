package com.oracle.test;

import com.oracle.dao.CarMapper;
import com.oracle.po.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {

	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession(true);
//		int i = session.getMapper(CarMapper.class).deleteByPrimaryKey(5);
//		System.out.println(session.getMapper(CarMapper.class).selectCars().size());
//		System.out.println(i);
		Car car=session.getMapper(CarMapper.class).selectByPrimaryKey(6);
		System.out.println(car);
//		Car car=session.getMapper(CarMapper.class).selectByPrimaryKey(2);
//		System.out.println(i);
	}

}
