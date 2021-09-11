package com.mszlu.blog.handler;


import com.mszlu.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@对加了controller注解的方法进行拦截处理  AOP的实现
@ControllerAdvice
public class AllExceptionHandler {
    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody //返回JSON数据
    public Result doRException(Exception ex){
        ex.printStackTrace();
        return Result.fail(-99,"系统异常");
    }
}
