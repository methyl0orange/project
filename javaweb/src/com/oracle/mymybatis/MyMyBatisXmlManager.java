package com.oracle.mymybatis;


import javax.lang.model.element.Element;
import java.io.File;
import java.io.IOException;

public class MyMyBatisXmlManager {
    private static String propertiesPath;
    static{
        SAXBuilder sb=new SAXBuilder();
        try {
            Document document=sb.build(new File("D:\\java\\javaweb\\src\\com\\oracle\\config\\mymybatis.xml"));
            Element root=document.getRootElement();
            Element propertiesElement=root.getChild("properties");
            propertiesPath=propertiesElement.getAttributeValue("location");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertiesPath() {
        return propertiesPath;
    }

    public static String[] getXmlPath() {
    }
}
