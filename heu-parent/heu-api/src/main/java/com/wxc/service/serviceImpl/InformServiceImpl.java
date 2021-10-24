package com.wxc.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wxc.common.Result;
import com.wxc.dao.mapper.InformMapper;
import com.wxc.dao.pojo.Inform;
import com.wxc.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformServiceImpl implements InformService {
    @Autowired
    private InformMapper informMapper;

    @Override
    public Result list() {
        LambdaQueryWrapper<Inform> informLambdaQueryWrapper=new LambdaQueryWrapper<>();
        informLambdaQueryWrapper.orderByAsc(Inform::getId);
        List<Inform> informList=informMapper.selectList(informLambdaQueryWrapper);
        return Result.SUCCESS(informList);
    }
}
