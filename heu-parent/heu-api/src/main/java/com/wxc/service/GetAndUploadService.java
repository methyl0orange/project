package com.wxc.service;

import com.wxc.common.Result;

public interface GetAndUploadService {
    //下面俩通过id找到卡和丢失的宝贝
    Result lookCardById(String id);
    Result lookTreasureById(Long treasureid);

    //通过token验证是否有效，有效的话得到openid并设置到领取人，将isget改为ture
    Result getTreasure(String token, Long id);

    Result getCard(String token, String cardid);
}
