package com.oracle.mymybatis;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplete {
    public int insertDeleteAndUpdate(String sql,Object...objects){
        ConnectionPool cp=new ConnectionPool();
        MyConnection mc=cp.getConnectionAble();
        if(mc!=null){
            Connection conn=mc.getConnection();
            try {
                PreparedStatement ps=conn.prepareStatement(sql);
                for (int i = 0; i <objects.length; i++) {
                    ps.setObject(i+1,objects[i]);
                }
                int i= ps.executeUpdate();
                mc.setFlag(false);
                return i;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    public List<Object> selectList(String sql,Class clazz,Object...objects) throws SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ConnectionPool cp=new ConnectionPool();
        MyConnection mc=cp.getConnectionAble();
        List<Object> list=new ArrayList<>();
        if(mc!=null){
            Connection conn=mc.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            for (int i = 0; i <objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Object obj=clazz.newInstance();
                //获取set方法
                Field[] fs=clazz.getDeclaredFields();
                for(Field field:fs){
                    String mstr="set"+Character.toUpperCase(field.getName().charAt(0))+field.getName().substring(1);
                    Method setm= clazz.getMethod(mstr,field.getType());
//                    setm.invoke(obj,rs.getObject(field.getName()));
                    if(field.getType().getSimpleName().equals("String")){
                        setm.invoke(obj,rs.getString(field.getName()));
                    }
                    if(field.getType().getSimpleName().equals("Integer")){
                        setm.invoke(obj,rs.getInt(field.getName()));
                    }
                }
                list.add(obj);
            }
            mc.setFlag(false);
        }
        return list;
    }
}
