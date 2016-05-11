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
		CasualTest aa=new CasualTest();
		String a=new String("3");
		System.out.println(aa);
	}
}
