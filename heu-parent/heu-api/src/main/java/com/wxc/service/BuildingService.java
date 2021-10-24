package com.wxc.service;

import com.wxc.common.Result;

public interface BuildingService {
    //丢失宝贝集中的地点列表
    Result list();

    Result notImgList();

    //通过地点的id找到地点的详细信息
    String findLocation(Integer buildingnum);

}
