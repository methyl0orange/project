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
	 * ����Ҫҵ���߼�����
	 */
	public List<Car> carList(Car car){

		return new CarDao().carList(car);
	}
	/**
	 * ��ѯ��������
	 * 
	 */
	public int carCount(Car car){
		return new CarDao().carCount(car);
	}
	
	/**
	 * ɾ������
	 */
	
	public boolean carDelete(Integer carid){
		return  new CarDao().carDelete(carid)>0?true:false;
	}
	
	/**
	 * �������
	 */
	public boolean carAdd(Car car){
		return  new CarDao().carAdd(car)>0?true:false;
	}
	/**
	 * ȥ�޸�����
	 */
	public Car toCarUpdate(Integer carid){
		return  new CarDao().toUpdateCar(carid);
	}
	/**
	 * �޸�����
	 */
	public boolean carUpdate(Car car){
		return  new CarDao().carUpdate(car)>0?true:false;
	}
	
	
}
