package com.wxc.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxc.common.Result;
import com.wxc.common.params.TreasureVo;
import com.wxc.dao.mapper.TreasureMapper;

import com.wxc.dao.pojo.Card;
import com.wxc.dao.pojo.Treasure;
import com.wxc.service.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreasureServiceImpl implements TreasureService {
    @Autowired
    private TreasureMapper treasureMapper;


    public Result list(Integer start){
        /**
         * 用mybatisplus分页功能进行查询
         *
         */
        Page<Treasure> page=new Page<>(start,10);
        LambdaQueryWrapper<Treasure> treasureLambdaQueryWrapper = new LambdaQueryWrapper<>();
        treasureLambdaQueryWrapper.orderByDesc(Treasure::getUptime);
        treasureLambdaQueryWrapper.eq(Treasure::isIsdisply,1);
        treasureLambdaQueryWrapper.eq(Treasure::isIsget,0);
        Page<Treasure> treasurePage =treasureMapper.selectPage(page,treasureLambdaQueryWrapper);

        List<Treasure> treasureList=treasurePage.getRecords();
        return Result.SUCCESS(this.copyOthers(treasureList));
    }

    @Override
    public TreasureVo findById(Long id) {
        LambdaQueryWrapper<Treasure> treasureLambdaQueryWrapper=new LambdaQueryWrapper<>();
        treasureLambdaQueryWrapper.eq(Treasure::getId,id);
        Treasure treasure=treasureMapper.selectOne(treasureLambdaQueryWrapper);
        TreasureVo treasureVo=copy(treasure);
        return treasureVo;
    }

    private List<TreasureVo> copyOthers(List<Treasure> treasureList){
        List<TreasureVo> treasureVoList =new ArrayList<>();
        for (Treasure treasure : treasureList){
            treasureVoList.add(copy(treasure));
        }
        return treasureVoList;
    }


    private TreasureVo copy(Treasure treasure){
        TreasureVo treasureVo =new TreasureVo();
        treasureVo.setId(treasure.getId());
        treasureVo.setDescribe(treasure.getDescription());
        treasureVo.setImageurl(treasure.getUrl());
        treasureVo.setRegistertime(treasure.getUptime());
        return treasureVo;
    }
}
