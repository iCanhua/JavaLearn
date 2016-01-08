package com.scut.fan.JavaMail;

import java.security.PublicKey;
import java.util.Properties;
import java.util.Properties;
import java.util.Stack;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.text.html.MinimalHTMLWriter;

public class Mail {
	
	private MimeMessage mimeMsg;// MIME邮件对象
	private Session session;// 邮件会话对象
	private Properties props; // 系统属�?
	// smtp认证用户名和密码
	private String username;
	private String password;
	
	private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象
	
	    /**
	     * Constructor
	     * 
	     * @param smtp
	     *            邮件发�?服务�?
	     */
	
	public Mail(String smtp){
        setSmtpHost(smtp);
        createMimeMessage();		
	}
	    /**
	     * 设置邮件发�?服务�?
	     * 
	     * @param hostName
	     *            String
	     */
	
	public void setSmtpHost(String hostName){
		if(props==null)
			props=System.getProperties();// 获得系统属�?对象
		props.put("mail.smtp.host",hostName);// 设置SMTP主机
		
	}
	
		/**
	     * 创建MIME邮件对象
	     * 
	     * @return
	     */
	public boolean createMimeMessage(){
		try {
			session = Session.getDefaultInstance(props, null);// 获得邮件会话对象
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("获取邮件会话对象时发生错误！"+e);
			return false;
		}
		
		
		try {
			mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
			mp = new MimeMultipart();
			System.out.println(mimeMsg);
			return true;
		} catch (Exception e) {
			System.err.println("创建MIME邮件对象失败"+e);
			return false;
		}
	}
	
	
		/**
	     * 设置SMTP是否�?��验证
	     * 
	     * @param need
	     */
	public void setNeedAuth(boolean need) {
		if( props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth","true");
		} else{
			props.put("mail.smtp.auth","false");
		}
	}
	
	/**
	 * 设置用户名和密码
	 * @param name
	 * @param pass
	 * */
	public void setNamePass(String name, String pass) {
		username = name;
		password = pass;
		}
	
	/**
	     * 设置邮件主题
	     * 
	     * @param mailSubject
	     * @return
	     */
	public boolean setSubject(String mailSubject){
		try {
			mimeMsg.setSubject(mailSubject);
			return true;
		} catch (Exception e) {
			System.err.println("设置邮件主题发生错误"+e);
			return false;
		}
		
	}
	
	 /**
     * 设置邮件正文
     * 
     * @param mailBody
     *            String
     */
    public boolean setBody(String mailBody) {
        try {
//        	 BodyPart <a href="https://www.baidu.com/s?wd=bp&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dWmHFBuhFhrAPbm1fLPjP-0AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtvrjDznjTdPH0krH6dnjRvnHc" target="_blank" class="baidu-highlight">bp</a> = new MimeBodyPart();
//             <a href="https://www.baidu.com/s?wd=bp&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dWmHFBuhFhrAPbm1fLPjP-0AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtvrjDznjTdPH0krH6dnjRvnHc" target="_blank" class="baidu-highlight">bp</a>.setContent("" + mailBody, "text/html;charset=utf-8");
//             mp.addBodyPart(<a href="https://www.baidu.com/s?wd=bp&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dWmHFBuhFhrAPbm1fLPjP-0AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtvrjDznjTdPH0krH6dnjRvnHc" target="_blank" class="baidu-highlight">bp</a>);
//             

        	 MimeBodyPart mbp1 = new MimeBodyPart();
        	 mbp1.setText(mailBody);
        	 mp.addBodyPart(mbp1);
        	 
            return true;
        } catch (Exception e) {
            System.err.println("设置邮件正文时发生错误！" + e);
            return false;
        }
    }
 
    /**
     * 添加附件
     * 
     * @param filename
     *            String
     */
    public boolean addFileAffix(String filename) {
 
        try {
            BodyPart bp = new MimeBodyPart();
            FileDataSource fileds = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(fileds));
            bp.setFileName(fileds.getName());
 
            mp.addBodyPart(bp);
 
            return true;
        } catch (Exception e) {
            System.err.println("增加邮件附件"+ filename + "发生错误" + e);
            return false;
        }
    }
 
    /**
     * 设置发信�?
     * 
     * @param from
     *            String
     */
    public boolean setFrom(String from) {
        try {
            mimeMsg.setFrom(new InternetAddress(from)); // 设置发信�?
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 
    /**
     * 设置收信�?
     * 
     * @param to
     *            String
     */
    public boolean setTo(String to) {
        if (to == null)
            return false;
        try {
            mimeMsg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 
    /**
     * 设置抄�?�?
     * 
     * @param copyto
     *            String
     */
    public boolean setCopyTo(String copyto) {
        if (copyto == null)
            return false;
        try {
            mimeMsg.setRecipients(Message.RecipientType.CC,
                    (Address[]) InternetAddress.parse(copyto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 
    /**
     * 发�?邮件
     */
    public boolean sendOut() {
        try {
            mimeMsg.setContent(mp);
            mimeMsg.saveChanges();
            System.out.println("正在发�?邮件....");
 
            Session mailSession = Session.getInstance(props, null);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"), username,
                    password);
            transport.sendMessage(mimeMsg,
                    mimeMsg.getRecipients(Message.RecipientType.TO));
//          如果抄�?人为null  不添加抄送人
            if(mimeMsg.getRecipients(Message.RecipientType.CC) != null)
                transport.sendMessage(mimeMsg,mimeMsg.getRecipients(Message.RecipientType.CC));
            // transport.send(mimeMsg);
 
            System.out.println("发送邮件成功");
            transport.close();
 
            return true;
        } catch (Exception e) {
            System.err.println("邮件发送失败" + e);
            e.printStackTrace();
            return false;
        }
    }
 
    /**
     * 调用sendOut方法完成邮件发�?
     * 
     * @param smtp
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param username
     * @param password
     * @return boolean
     */
    public static boolean send(String smtp, String from, String to,
            String subject, String content, String username, String password) {
        Mail theMail = new Mail(smtp);
        theMail.setNeedAuth(true); // �?��验证
 
        if (!theMail.setSubject(subject))
            return false;
        if (!theMail.setBody(content))
            return false;
        if (!theMail.setTo(to))
            return false;
        if (!theMail.setFrom(from))
            return false;
        theMail.setNamePass(username, password);
 
        if (!theMail.sendOut())
            return false;
        return true;
    }
 
    /**
     * 调用sendOut方法完成邮件发�?,带抄�?
     * 
     * @param smtp
     * @param from
     * @param to
     * @param copyto
     * @param subject
     * @param content
     * @param username
     * @param password
     * @return boolean
     */
    public static boolean sendAndCc(String smtp, String from, String to,
            String copyto, String subject, String content, String username,
            String password) {
        Mail theMail = new Mail(smtp);
        theMail.setNeedAuth(true); // �?��验证
 
        if (!theMail.setSubject(subject))
            return false;
        if (!theMail.setBody(content))
            return false;
        if (!theMail.setTo(to))
            return false;
        if (!theMail.setCopyTo(copyto))
            return false;
        if (!theMail.setFrom(from))
            return false;
        theMail.setNamePass(username, password);
 
        if (!theMail.sendOut())
            return false;
        return true;
    }
 
    /**
     * 调用sendOut方法完成邮件发�?,带附�?
     * 
     * @param smtp
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param username
     * @param password
     * @param filename
     *            附件路径
     * @return
     */
    public static boolean send(String smtp, String from, String to,
            String subject, String content, String username, String password,
            String filename) {
        Mail theMail = new Mail(smtp);
        theMail.setNeedAuth(true); // �?��验证
 
        if (!theMail.setSubject(subject))
            return false;
        if (!theMail.setBody(content))
            return false;
        if (!theMail.addFileAffix(filename))
            return false;
        if (!theMail.setTo(to))
            return false;
        if (!theMail.setFrom(from))
            return false;
        theMail.setNamePass(username, password);
 
        if (!theMail.sendOut())
            return false;
        return true;
    }
 
    /**
     * 调用sendOut方法完成邮件发�?,带附件和抄�?
     * 
     * @param smtp
     * @param from
     * @param to
     * @param copyto
     * @param subject
     * @param content
     * @param username
     * @param password
     * @param filename
     * @return
     */
    public static boolean sendAndCc(String smtp, String from, String to,
            String copyto, String subject, String content, String username,
            String password, String filename) {
        Mail theMail = new Mail(smtp);
        theMail.setNeedAuth(true); // �?��验证
 
        if (!theMail.setSubject(subject))
            return false;
        if (!theMail.setBody(content))
            return false;
        if (!theMail.addFileAffix(filename))
            return false;
        if (!theMail.setTo(to))
            return false;
        if (!theMail.setCopyTo(copyto))
            return false;
        if (!theMail.setFrom(from))
            return false;
        theMail.setNamePass(username, password);
 
        if (!theMail.sendOut())
            return false;
        return true;
    }
 
    public static void main(String[] args) {
////        SMTP服务�?
        String smtp = "smtp.126.com";
//      发信�?         fancanhuade@126.com
        String from = "fancanhuade@126.com";
        String to = "525921307@qq.com";
        String subject = "subject";
        String content = "钊生�?94SB";
        String username = "fancanhuade@126.com";
        String password = "ekhbeqxyjrfxbnck";
        Mail.send(smtp, from, to, subject, content, username, password);
//        Throwable t=new Throwable();
//        StackTraceElement[] frames=t.getStackTrace();
//        for(StackTraceElement frame :frames){
//        	System.out.println(frame.toString());
//        }
    }
	

}
