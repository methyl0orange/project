package com.wxc.service;

import com.wxc.common.Result;
import com.wxc.common.params.TreasureVo;

public interface TreasureService {

    //显示第start页
    Result list(Integer start);

    TreasureVo findById(Long id);
}
