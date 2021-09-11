package com.java.sport.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class LogAOP {

	    @Pointcut("execution(* com.oracle.ssm.service.Impl.*.*(..))")
	    private void anyMethod(){}
	    

	    @Before("anyMethod()")
	    public void doAccessCheck(){  
	    	System.out.println("前置通知");
	    } 

	    @AfterReturning("anyMethod()")
	    public void doAfter(){
	        System.out.println("最终通知");
	    }  
	      
	    @After("anyMethod()")  
	    public void after(){  
	        System.out.println("后置通知");
	    }  

	    @AfterThrowing("anyMethod()")  
	    public void doAfterThrow(){
	        System.out.println("例外通知");
	    }  
	      
	    @Around("anyMethod()")  
	    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{  
	        System.out.println("进入环绕通知");
	        Object object = pjp.proceed();
	        System.out.println("结束环绕通知");
	        return object;  
	    }
}
