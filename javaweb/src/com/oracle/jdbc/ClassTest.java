package com.oracle.jdbc;

import com.oracle.po.s;

import java.lang.reflect.*;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //反射类型
        Class clazz1= s.class;
        Class clazz2=new s().getClass();
        Class clazz3=Class.forName("com.oracle.po.s");
        /*//获取类中属性
        try {
            //Field f1=clazz1.getField("SNo");// 获取共有属性
            //Field[] f2=clazz1.getFields();//获取所有共有属性(由于其为私有属性，无效代码)
            Field f3=clazz1.getDeclaredField("SNo");//获取共有，私有，受保护，默认属性
            //System.out.println(f3.getModifiers()+" \t"+f3.getType().getName()+" \t"+f3.getName());
            //System.out.println(f3.getModifiers()+" \t"+f3.getType().getSimpleName()+" \t"+f3.getName());
            Field[] f4=clazz1.getDeclaredFields();//获取所有共有，私有，受保护，默认属性
            for(Field field:f4){
                System.out.println(field.getModifiers()+" \t"+field.getType().getSimpleName()+" \t"+field.getName());
            }



        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/
        //获取方法
        Method m1=clazz2.getMethod("setDept", String.class);//公有方法
//        Method[] m2=clazz2.getMethods();//所有公有方法
//        Method m3=clazz2.getDeclaredMethod("setAge", Integer.class);//公有，私有
 //       Method[] m4=clazz2.getDeclaredMethods();//所有共有，私有方法
 //       Parameter[] ps=m1.getParameters();
 //       String str="";
//        for(Parameter parameter:ps){
//            str+=parameter.getName()+",";
//        }
//        System.out.println(m1.getModifiers()+"\t"+m1.getReturnType().getSimpleName()+"\t"+m1.getName()+"\t("+str+")");


/*        //实例化一个对象
        try {
            s ss=(s)clazz2.newInstance();
            m1.invoke(ss,"asd");
            System.out.println(ss.getDept());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/


        //构造方法
        Constructor c1=clazz3.getConstructor();
        Constructor[] c2=clazz3.getConstructors();
        Constructor c3=clazz3.getDeclaredConstructor();
        Constructor[] c4=clazz3.getDeclaredConstructors();
    }
}
