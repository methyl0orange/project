package proxyModel.CGLib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank= (Tank) enhancer.create();
        tank.move();
    }
}


class Tank{
    public void move(){
        System.out.println("tank move calala---");
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before");
        Object result=null;
        result=methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return result;
    }
}