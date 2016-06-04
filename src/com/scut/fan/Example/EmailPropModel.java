package com.scut.fan.Example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.scut.fan.JavaMail.*;
/**
 * 该类为邮件配置模型，读取根目录下的EmailPropModel.properties
 * @author FAN
 *
 */
public class EmailPropModel implements EmailPropFormat{
	
	String MailTransportProtocol;
	String MailSmtpHost;
	String MailSmtpPort;
	String SenderEmailPwd;
	String SenderEmail;
	static final String propPath="./EmailPropModel.properties";
	String isAuth="true";
	
	public EmailPropModel(){
		init();
	}
	public void init(){
		Properties prop = new Properties(); //配置文件读取器
		InputStream in=EmailUtils.class.getResourceAsStream(propPath);//装载流
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Exception noProExcpt=new Exception("无法读取配置文件，请检查路径");
			noProExcpt.printStackTrace();
			e.printStackTrace();
		}
		this.setMailTransportProtocol(prop.getProperty("MailTransportProtocol","smtp"));
		this.setMailSmtpHost(prop.getProperty("MailSmtpHost","smtp.126.com"));
		this.setMailSmtpPort(prop.getProperty("MailSmtpPort","25"));
		this.setAuth("true");
		this.setSenderEmail(prop.getProperty("SenderEmail"));
		this.setSenderEmailPwd(prop.getProperty("SenderEmailPwd"));
	}
	
	public String getMailTransportProtocol() {
		return MailTransportProtocol;
	}
	public void setMailTransportProtocol(String mailTransportProtocol) {
		MailTransportProtocol = mailTransportProtocol;
	}
	public String getMailSmtpHost() {
		return MailSmtpHost;
	}
	public void setMailSmtpHost(String mailSmtpHost) {
		MailSmtpHost = mailSmtpHost;
	}
	public String getMailSmtpPort() {
		return MailSmtpPort;
	}
	public void setMailSmtpPort(String mailSmtpPort) {
		MailSmtpPort = mailSmtpPort;
	}
	public String isAuth() {
		return isAuth;
	}
	public void setAuth(String isAuth) {
		this.isAuth = isAuth;
	}
	public String getSenderEmailPwd() {
		return SenderEmailPwd;
	}
	public void setSenderEmailPwd(String senderEmailPwd) {
		SenderEmailPwd = senderEmailPwd;
	}
	public String getSenderEmail() {
		return SenderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		SenderEmail = senderEmail;
	}
	
	

}
