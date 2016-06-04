package com.scut.fan.JavaMail;

import java.util.Date;

public interface EmailInfoFormat {
	public String getSubject();
	
	public Date getSendDate();
	
	public String getFrom();
	
	public String getTo() ;
	
	public String getContent();
	

}
