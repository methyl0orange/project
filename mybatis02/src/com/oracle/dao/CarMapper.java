package com.oracle.dao;

import java.util.List;

import com.oracle.po.Car;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carid);

    int updateByPrimaryKeySelective(Car record);


    List<Car> selectCars();
}