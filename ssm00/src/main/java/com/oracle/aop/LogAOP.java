package com.oracle.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAOP {

    @Pointcut("execution(* com.oracle.service.impl.*.*(..))")
    private void anyMethod(){ }//定义一个切入点

    //前置通知&&args(userId,userName)
    @Before(value = "anyMethod()")
    public void doAccessCheck(){
        System.out.println("前置");
    }

    //返回通知，最终通知
    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("返回通知");
    }

    @After("anyMethod()")
    public void after(){
        System.out.println("后置通知");
    }


    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("异常通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("进入环绕通知");
        Object object=pjp.proceed();//执行该方法
        System.out.println("退出该方法");
        return object;
    }
}
