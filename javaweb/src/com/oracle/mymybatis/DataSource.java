package com.oracle.mymybatis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataSource {
    private String driver;
    private String url;
    private String username;
    private String password;

    public DataSource() throws FileNotFoundException {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(MyMyBatisXmlManager.getPropertiesPath()));
            driver=properties.getProperty("mysql.driver");
            url=properties.getProperty("mysql.url");
            password=properties.getProperty("mysql.password");
            username=properties.getProperty("mysql.username");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
