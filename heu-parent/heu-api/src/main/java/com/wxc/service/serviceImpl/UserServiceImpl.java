package com.wxc.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wxc.dao.mapper.UserMapper;
import com.wxc.dao.pojo.User;
import com.wxc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean HasOpenId(String openid) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper=new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getOpenid,openid);
        User user=userMapper.selectOne(userLambdaQueryWrapper);
        if(user!=null){return true;}
        return false;
    }

    @Override
    public Boolean InsertUser(User user) {
        int insert = userMapper.insert(user);
        if(insert==0){return false;}
        return true;
    }
}
