package com.scut.fan.JavaMail;


/**
 * 该类为邮件发送模板，采用模板方法模式，封装发送流程算法，子类实现两个抽象算法，分别设置prop和info属性;
 * 该模板使用prop对象方式去实现邮件发送，ExcelUtils可以不使用该方式，EmailUtils仅依赖接口，具体看该类DOC文档；
 * @author FAN
 *
 */
public abstract class AbstractEmailTemplate {
	
	EmailInfoFormat info;
	EmailPropFormat prop;
	
	public EmailInfoFormat getInfo() {
		return info;
	}

	public void setInfo(EmailInfoFormat info) {
		this.info = info;
	}

	public EmailPropFormat getProp() {
		return prop;
	}

	public void setProp(EmailPropFormat prop) {
		this.prop = prop;
	}
	/**
	 * 子类自定义prop
	 * @return 邮件发送配置
	 */
	public abstract EmailPropFormat initEmailProp();
	/**
	 * 子类自定义info
	 * @return 邮件内容信息
	 */
	public abstract EmailInfoFormat initEmailInfo();
	
	/**
	 * 封装邮件发送流程
	 * @throws Exception 发送错误
	 */
	public void sendEmail() throws Exception{
		setProp(initEmailProp());
		setInfo(initEmailInfo());
		EmailUtils.setProp(getProp());
		EmailUtils.sendEmail(getInfo());
		
	}

}
