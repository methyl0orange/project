package com.oracle.dao;

import com.oracle.po.Car;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(Car record);

    Car selectByPrimaryKey(Integer carid);

    List<Car> selectCars();
}