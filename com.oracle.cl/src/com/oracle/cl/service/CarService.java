package com.oracle.cl.service;

import java.util.List;

import com.oracle.cl.dao.CarDao;
import com.oracle.cl.po.Car;

/**
 * 
 * @author aqiu
 *
 */
public class CarService {

	/**
	 * 不需要业务逻辑处理
	 */
	public List<Car> carList(Car car){

		return new CarDao().carList(car);
	}
	/**
	 * 查询数据总数
	 * 
	 */
	public int carCount(Car car){
		return new CarDao().carCount(car);
	}
	
	/**
	 * 删除数据
	 */
	
	public boolean carDelete(Integer carid){
		return  new CarDao().carDelete(carid)>0?true:false;
	}
	
	/**
	 * 添加数据
	 */
	public boolean carAdd(Car car){
		return  new CarDao().carAdd(car)>0?true:false;
	}
	/**
	 * 去修改数据
	 */
	public Car toCarUpdate(Integer carid){
		return  new CarDao().toUpdateCar(carid);
	}
	/**
	 * 修改数据
	 */
	public boolean carUpdate(Car car){
		return  new CarDao().carUpdate(car)>0?true:false;
	}
	
	
}
