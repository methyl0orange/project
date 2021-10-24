package com.wxc.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxc.common.Result;
import com.wxc.common.params.CardVo;
import com.wxc.dao.mapper.CardMapper;
import com.wxc.dao.pojo.Card;
import com.wxc.service.BuildingService;
import com.wxc.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Override
    public Result cardList(Integer start) {
        Page<Card> page=new Page<>(start,20);
        LambdaQueryWrapper<Card> cardLambdaQueryWrapper = new LambdaQueryWrapper<>();
        cardLambdaQueryWrapper.orderByDesc(Card::getUptime);
        cardLambdaQueryWrapper.eq(Card::isIsdisply,1);
        Page<Card> cardPage = cardMapper.selectPage(page,cardLambdaQueryWrapper);
        Long total=page.getTotal();
        if(start>(total/20)){
            Page<Card> pagenew=new Page<>(1,20);
            cardPage = cardMapper.selectPage(pagenew,cardLambdaQueryWrapper);
        }
        List<Card> cardList=cardPage.getRecords();
        return Result.SUCCESS(this.copyCard(cardList));
    }
    private List<CardVo> copyCard(List<Card> cardList){
        List<CardVo> cardVoList=new ArrayList<>();
        for (Card card:cardList){
            cardVoList.add(copy(card));
        }
        return  cardVoList;
    }
    private CardVo copy(Card card){
        CardVo cardVo=new CardVo();
        cardVo.setCarid(card.getCardid());
        cardVo.setName(card.getName());
        cardVo.setRegistertime(card.getUptime());
        return cardVo;
    }
}
