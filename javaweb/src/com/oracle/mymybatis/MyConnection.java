package com.oracle.mymybatis;

import java.sql.Connection;

public class MyConnection {
    private Connection connection;
    private boolean flag;

    public MyConnection(Connection connection,boolean flag) {
        this.connection = connection;
        this.flag=flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Connection getConnection() {
        return connection;
    }
}
