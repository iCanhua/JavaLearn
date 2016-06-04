package com.scut.fan.Practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.scut.fan.DOM.acxReader;

public class CasualTest {
	
	
	
	
	interface C{
		public String getUrl();
	}
	class ConnectToServer{
		public String getUrl(C urlGeter){
			String temp=urlGeter.getUrl();
			return temp;
		}
	}
	
	class Brequest implements C{
		@Override
		public String getUrl() {
			return "urlA";
		}
	}
	class Crequest implements C{
		@Override
		public String getUrl() {
			return "urlB";
		}
	}
	class Drequest implements C{
		@Override
		public String getUrl() {
			return "urlC";
		}
	}
	
	public void connect(){
		ConnectToServer conn=new ConnectToServer();
		Brequest B=new Brequest();
		conn.getUrl(B);
		
	}
	
	public static void main(String[] args) {
		Rect rect =new Rect();
		Dbl w=new Dbl(),h=new Dbl();
		w.setD(12.76);
		h.setD(25.28);
		rect.setHeight(h);
		rect.setWidth(w);
		System.out.println("矩形："+rect.getHeight()+"-"+rect.getWidth());
		System.out.println("面积："+rect.getArea());
		w.setD(100.0);
		h.setD(256.0);
		System.out.println("矩形："+rect.getHeight()+"-"+rect.getWidth());
		
	}
}
