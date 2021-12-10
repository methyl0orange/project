package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectedClass {
    private String name;
    private int age;

    public String sex;
    public ReflectedClass() {

    }

    public ReflectedClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class ReflectedClassMain{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.forName
        Class clazz=Class.forName("com.reflect.ReflectedClass");
        System.out.println(clazz);
        ReflectedClass reflectedClass= (ReflectedClass)clazz.newInstance();
        System.out.println(reflectedClass);
        Constructor[] constructors=clazz.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println("构造方法"+constructor.toString());
        }
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            System.out.println("字段"+field.toString());
        }
        Method[] methods=clazz.getMethods();
        for(Method method:methods){
            System.out.println("方法"+method.toString());
        }
        Method m=clazz.getMethod("setName", String.class);
        System.out.println("自己想实现得方法"+m);
        m.invoke(reflectedClass,"wxc");
        System.out.println(reflectedClass.getName());
    }
}