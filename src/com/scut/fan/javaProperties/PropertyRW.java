package com.scut.fan.JavaProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;


public class PropertyRW {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties(); 
		InputStream in=PropertyRW.class.getResourceAsStream("/a.properties");
		prop.load(in);     ///加载属性列表
        Iterator<String> it=prop.stringPropertyNames().iterator();
        while(it.hasNext()){
            String key=it.next();
            System.out.println(key+":"+prop.getProperty(key));
        }
        in.close();
	}
}
