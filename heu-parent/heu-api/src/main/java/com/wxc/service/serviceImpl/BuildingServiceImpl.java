package com.wxc.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wxc.common.Result;
import com.wxc.common.cache.Cache;
import com.wxc.dao.mapper.BuildingMapper;
import com.wxc.dao.pojo.Building;
import com.wxc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;
    @Cache(expire = 10*60*1000,name = "buildinglist")
    @Override
    public Result list() {
        LambdaQueryWrapper<Building> buildingLambdaQueryWrapper=new LambdaQueryWrapper<>();
        //是否置顶排序
        //order by create_date desc
        buildingLambdaQueryWrapper.orderByAsc(Building::getBuildingnum);
        List<Building> buildingList = buildingMapper.selectList(buildingLambdaQueryWrapper);
        return Result.SUCCESS(buildingList);

    }

    @Cache(expire = 10*60*1000,name = "buildingnoimglist")
    @Override
    public Result notImgList() {
        LambdaQueryWrapper<Building> buildingLambdaQueryWrapper=new LambdaQueryWrapper<>();
        //是否置顶排序
        //order by create_date desc
        buildingLambdaQueryWrapper.orderByAsc(Building::getBuildingnum);
        List<Building> buildingList = buildingMapper.selectList(buildingLambdaQueryWrapper);
        for (Building build:buildingList) {
            build.setBuildingurl(null);
        }
        return Result.SUCCESS(buildingList);
    }

    @Override
    public String findLocation(Integer buildingnum) {
        LambdaQueryWrapper<Building> buildingLambdaQueryWrapper=new LambdaQueryWrapper<>();
        buildingLambdaQueryWrapper.eq(Building::getBuildingnum,buildingnum);
        Building building=buildingMapper.selectOne(buildingLambdaQueryWrapper);
        return building.getLocation();
    }
}
