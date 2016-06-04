package com.scut.fan.JavaMail;


/**
 * ����Ϊ�ʼ�����ģ�壬����ģ�巽��ģʽ����װ���������㷨������ʵ�����������㷨���ֱ�����prop��info����;
 * ��ģ��ʹ��prop����ʽȥʵ���ʼ����ͣ�ExcelUtils���Բ�ʹ�ø÷�ʽ��EmailUtils�������ӿڣ����忴����DOC�ĵ���
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
	 * �����Զ���prop
	 * @return �ʼ���������
	 */
	public abstract EmailPropFormat initEmailProp();
	/**
	 * �����Զ���info
	 * @return �ʼ�������Ϣ
	 */
	public abstract EmailInfoFormat initEmailInfo();
	
	/**
	 * ��װ�ʼ���������
	 * @throws Exception ���ʹ���
	 */
	public void sendEmail() throws Exception{
		setProp(initEmailProp());
		setInfo(initEmailInfo());
		EmailUtils.setProp(getProp());
		EmailUtils.sendEmail(getInfo());
		
	}

}
