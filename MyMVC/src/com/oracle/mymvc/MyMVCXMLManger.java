package com.oracle.mymvc;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
/**
 * 
 * @author aqiu
 *  ����xml�ļ�����ȡ����������ͷ���֮���ӳ���ϵ
 */
public class MyMVCXMLManger {

	private Map<String, ClassMethod> map = new HashMap<>();

	public Map<String, ClassMethod> getMap() {
		return map;
	}
	
	public MyMVCXMLManger() throws Exception{
		SAXBuilder sb = new SAXBuilder();
		Document document = sb.build(new File("mymvc.xml"));
		Element root = document.getRootElement();
		List<Element> elist = root.getChildren();
		for (Element element : elist) {
			
			String key = element.getAttributeValue("id");
			ClassMethod value = new ClassMethod();
			value.setClassName(element.getAttributeValue("class"));
			value.setMethodName(element.getAttributeValue("method"));
			map.put(key, value);
		}
	}
}
