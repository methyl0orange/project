package com.oracle.sport.commons;

public class Array2String {

	public static String array2String(String[] strs){
		String paramStrs = "";
		for(int i=0;i<strs.length;i++){
			if(i == strs.length-1){
				paramStrs += strs[i];
			}else{
				paramStrs += strs[i]+",";
			}
			
		}
		return paramStrs;
	}
}
