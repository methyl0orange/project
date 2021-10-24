package com.wxc.service;

import com.wxc.common.Result;

public interface LoginService {
    //通过个人code得到每个微信独一无二的openid
    Result GetAppId(String code);

    //在redis中查询token,如果有返回openid，没有返回null
    String checkToken(String token);
}
