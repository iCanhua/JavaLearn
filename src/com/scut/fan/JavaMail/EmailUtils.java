package com.scut.fan.JavaMail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * 该类为邮件发送使用工具，封装主要的邮件发送流程，全部静态代码，仅依赖配置接口Properable和内容接口EmailFormter
 * 设计模式为策略模式，prop的实现可以用多种策略
 * @author FAN
 *
 */
public class EmailUtils {
	/**
	 * prop为邮件链接配置属性接口，只有实现该协议的属性能被邮件正确使用
	 * 设计模式为策略模式，prop的实现可以用多种策略
	 */
	static EmailPropFormat prop;

	public static void setProp(EmailPropFormat propinstance) {
		prop=propinstance;
	}
	
	private static EmailPropFormat getProp() throws PropNullException {
		if(prop==null){
			throw new PropNullException();
		}else{
			return prop;
		}
	}
	
	/**
	 * 获取会话信息，该方法被保护，与porp属性相依赖
	 * @return
	 */
	private static Session getSession() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", prop.getMailTransportProtocol());
		props.setProperty("mail.smtp.host", prop.getMailSmtpHost());
		props.setProperty("mail.smtp.port", prop.getMailSmtpPort());
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override //鍐呴儴绫昏幏鍙栭厤缃枃浠剁殑瀵嗙爜
			protected PasswordAuthentication getPasswordAuthentication() {
				String from=null;
				try {
					from = EmailUtils.getProp().getSenderEmail();
				} catch (PropNullException e) {
					e.printStackTrace();
				}
				String password=null;
				try {
					password = EmailUtils.getProp().getSenderEmailPwd();
				} catch (PropNullException e) {
					e.printStackTrace();
				}
				
			return new PasswordAuthentication(from, password);
			}
			
		});
		return session;
	}
	
	/**
	 * EmialUtils对外提供接口，封装发送邮件流程
	 * @param emailprop 邮件的发送配置属性
	 * @param eamilinfo 邮件发送内容信息
	 * @return
	 * @throws Exception 
	 */
	public static boolean sendEmail(EmailInfoFormat emailinfo) throws Exception {
		if(prop==null){
			throw new PropNullException();
		}
		Session session = getSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setSubject(emailinfo.getSubject());
			message.setSentDate(emailinfo.getSendDate());
			message.setFrom(new InternetAddress(emailinfo.getFrom()));
			message.setRecipient(RecipientType.TO, new InternetAddress(emailinfo.getTo()));
			message.setContent(emailinfo.getContent(),"text/html;charset=utf-8");
			Transport.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


}
