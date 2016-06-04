package com.scut.fan.JavaMail;


import java.util.Date;
/**
 * 该类为邮件信息模板类，意义不大，仅作参考；
 * @author FAN
 *
 */
public abstract class AbstractEmailInfo implements EmailInfoFormat {

	String subject;
	Date sendDate;
	String from;
	String to;
	String content;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	


	public AbstractEmailInfo() {
		EmailEdit();
	}
	public abstract void EmailEdit();
	

}
