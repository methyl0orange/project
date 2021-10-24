package com.wxc.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wxc.common.Result;
import com.wxc.common.ResultCode;
import com.wxc.common.params.CardVo;
import com.wxc.common.params.TreasureVo;
import com.wxc.dao.mapper.CardMapper;
import com.wxc.dao.mapper.TreasureMapper;
import com.wxc.dao.pojo.Card;
import com.wxc.dao.pojo.Treasure;
import com.wxc.service.BuildingService;
import com.wxc.service.GetAndUploadService;
import com.wxc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetAndUploadServiceImpl implements GetAndUploadService {
    @Autowired
    private CardMapper cardMapper;
    @Override
    public Result lookCardById(String id) {
        LambdaQueryWrapper<Card> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Card::getCardid,id);
        Card card=cardMapper.selectOne(lambdaQueryWrapper);
        return Result.SUCCESS(copy(card));
    }
    @Autowired
    private TreasureMapper treasureMapper;

    @Override
    public Result lookTreasureById(Long treasureid) {
        LambdaQueryWrapper<Treasure> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Treasure::getId,treasureid);
        Treasure treasure=treasureMapper.selectOne(lambdaQueryWrapper);
        return Result.SUCCESS(copy(treasure));
    }
    @Autowired
    private LoginService loginService;

    @Override
    public Result getTreasure(String token, Long id) {
        String openid = loginService.checkToken(token);
        if(openid==null){
            return Result.FAIL(ResultCode.TOKEN_ERROR.code(),ResultCode.TOKEN_ERROR.message());
        }
        Treasure treasure=new Treasure();
        //设置主页显示状态为否
        treasure.setIsget(true);
        //设置领取人
        treasure.setGetuser(openid);
        treasure.setId(id);
        int row=treasureMapper.updateById(treasure);
        if(row==1){
            return Result.SUCCESS();
        }
        return Result.FAIL(ResultCode.UPDATE_FAIL.code(),ResultCode.UPDATE_FAIL.message());
    }

    @Override
    public Result getCard(String token, String cardid) {
        String openid = loginService.checkToken(token);
        if(openid==null){
            return Result.FAIL(ResultCode.TOKEN_ERROR.code(),ResultCode.TOKEN_ERROR.message());
        }
        Card card=new Card();
        //设置主页显示状态为否
        card.setIsdisply(false);
        //设置领取人
        card.setGetuser(openid);
        card.setCardid(cardid);
        int row=cardMapper.updateById(card);
        if(row==1){
            return Result.SUCCESS();
        }
        return Result.FAIL(ResultCode.UPDATE_FAIL.code(),ResultCode.UPDATE_FAIL.message());
    }

    @Autowired
    private BuildingService buildingService;
    private CardVo copy(Card card){
        CardVo cardVo=new CardVo();
        cardVo.setCarid(card.getCardid());
        cardVo.setName(card.getName());
        cardVo.setRegistertime(card.getUptime());
        cardVo.setLocation(buildingService.findLocation(card.getLocationnum()));
        return cardVo;
    }

    private TreasureVo copy(Treasure treasure){
        TreasureVo treasureVo =new TreasureVo();
        treasureVo.setId(treasure.getId());
        treasureVo.setDescribe(treasure.getDescription());
        treasureVo.setImageurl(treasure.getUrl());
        treasureVo.setRegistertime(treasure.getUptime());
        treasureVo.setLocation(buildingService.findLocation(treasure.getLocationnum()));
        return treasureVo;
    }
}
