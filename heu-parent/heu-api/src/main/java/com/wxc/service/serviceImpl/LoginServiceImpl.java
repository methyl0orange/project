package com.wxc.service.serviceImpl;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.common.utils.StringUtils;
import com.wxc.common.Result;
import com.wxc.common.ResultCode;
import com.wxc.dao.pojo.User;
import com.wxc.service.LoginService;
import com.wxc.service.UserService;
import com.wxc.utils.JWTUtils;
import com.wxc.utils.OpenIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserService userService;
    @Override
    public Result GetAppId(String code) {
        String result = OpenIdUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session",
                "appid=wx8dc92655673fbca1" +
                        //小程序APPID
                        "&secret=e06fa7de4e1ef6241aab178ccbb2fad4" +
                        //小程序秘钥
                        "&js_code="+ code +
                        //前端传来的code
                        "&grant_type=authorization_code");

        System.out.println("-------"+result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (jsonObject.containsKey("errcode")) {
            return Result.FAIL(ResultCode.OPENID_ERROR.code(),ResultCode.OPENID_ERROR.message());
        }
        String openid = jsonObject.get("openid").toString();
        String session_key=jsonObject.get("session_key").toString();
        System.out.println(openid+"---"+session_key);
        if(userService.HasOpenId(openid)){

        }else{
            User user=new User();
            user.setOpenid(openid);
            userService.InsertUser(user);
        }
        String token= JWTUtils.createToken(openid);

        System.out.println(token);
        redisTemplate.opsForValue().set("TOKEN"+token,openid);
        System.out.println("&&&&&&&"+redisTemplate.opsForList().toString());
        return Result.SUCCESS(token);
    }

    @Override
    public String checkToken(String token) {
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if(stringObjectMap==null){
            return null;
        }
        String openid = redisTemplate.opsForValue().get("TOKEN" + token);
        System.out.println("mdzz====="+openid);
        return openid;
    }
}
