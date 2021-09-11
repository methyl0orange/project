package com.mszlu.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.mszlu.blog.common.aop.LogAnnotation;
import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.service.LoginService;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.utils.JWTUtils;
import com.mszlu.blog.vo.ErrorCode;
import com.mszlu.blog.vo.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import com.mszlu.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
public class LoginServiceImpl implements LoginService {
    private  static final String salt="mszlu!@#";
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public Result login(LoginParam loginParam) {
        /*
        *1.检查参数是否合法
        * 2.根据用户名和密码去USER表中查询 是否存在
        * 3.如果不存在 登陆失败
        * 4.如果存在 使用jwt生成token返回前端
        * 5.token 放入redis中 设置过期时间
        * （登录认证的时候 先认证token字符串是否合法，去redis中认证是否存在）
         */
        String account=loginParam.getAccount();
        String password=loginParam.getPassword();
        if(StringUtils.isBlank(account)||StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        password= DigestUtils.md5Hex(password + salt);
        SysUser sysUser=sysUserService.findUser(account,password);
        if(sysUser==null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(),ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token= JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("token_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public SysUser checkToken(String token) {
        if(StringUtils.isBlank(token)){
            return null;
        }
        Map<String,Object> stringObjectMap=JWTUtils.checkToken(token);
        if(stringObjectMap==null){
            return null;
        }
        String userJson=redisTemplate.opsForValue().get("TOKEN_" + token);
        if(StringUtils.isBlank(userJson)){
            return null;
        }
        SysUser sysUser=JSON.parseObject(userJson,SysUser.class);
        return sysUser;
    }

    @Override
    public Result logout(String token) {
        redisTemplate.delete("TOKEN_"+token);
        return Result.success(null);
    }

    @Override
    public Result register(LoginParam loginParam) {
        /*
        * 1.判断参数是否合法
        * 2，判断账户是否存在  存在返回账户已经被注册
        * 3.如果不存在
        * 生成token 并返回
        * 4.存入redis 返回
        * 5.有问题需要回滚
        * */
        String account=loginParam.getAccount();
        String password=loginParam.getPassword();
        String nickname=loginParam.getNickname();
        if(StringUtils.isBlank(account)||
           StringUtils.isBlank(password)||
           StringUtils.isBlank(nickname)){
            return  Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        SysUser sysUser=sysUserService.findUserByAccount(account);
        if(sysUser!=null){
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(),ErrorCode.ACCOUNT_EXIST.getMsg());
        }
        sysUser=new SysUser();
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(DigestUtils.md5Hex(password+salt));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");
        sysUser.setAdmin(1);
        sysUser.setDeleted(0);
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setEmail("");
        this.sysUserService.save(sysUser);
        String token= JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("token_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return Result.success(token);
    }
}
