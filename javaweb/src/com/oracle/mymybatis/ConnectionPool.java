package com.oracle.mymybatis;


import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static DataSource dataSource;
    private static List<MyConnection> list=new ArrayList<>();
    static{
        try {
            dataSource=new DataSource();
            Class.forName(dataSource.getDriver());
            Connection con=null;
            for (int i = 0; i < 5; i++) {
                con= DriverManager.getConnection(dataSource.getUrl(),dataSource.getUsername(),dataSource.getPassword());
                list.add(new MyConnection(con,false));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized MyConnection getConnectionAble() {
        MyConnection myConnection=null;
        for(MyConnection mc:list){
            if(!mc.isFlag()){
                System.out.println("链接可用");
                mc.setFlag(true);
                myConnection=mc;
                return myConnection;
            }
        }
        if(myConnection==null){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void setMyConnection() {
        ConnectionPool.list = list;
    }
}
