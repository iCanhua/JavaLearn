package com.scut.fan.JavaMail;

public class PropNullException extends Exception {
	public PropNullException(String msg){
		super(msg);
	}
	
	public PropNullException(){
		super("Email未配置基本属性，例如协议、端口");
	}

}
