package com.wxc.service;

import com.wxc.dao.pojo.User;

public interface UserService {
    Boolean HasOpenId(String openid);
    Boolean InsertUser(User user);
}
