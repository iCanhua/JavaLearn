package com.scut.fan.JavaMail;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;

import com.scut.fan.JavaMail.AbstractEmailTemplate;
import com.scut.fan.JavaMail.EmailInfoFormat;
import com.scut.fan.JavaMail.EmailPropFormat;
import com.scut.fan.JavaMail.EmailPropModel;


/**
 * �����ʻ���������������������
 * @author FAN
 *
 */
public class AccountActivateExample extends AbstractEmailTemplate{
	EmailPropModel prop1=new EmailPropModel();
	AccountActivateEmailInfo info =new AccountActivateEmailInfo();
	
	@Override
	public EmailPropFormat initEmailProp() {
		return prop1; 
	}

	@Override
	public EmailInfoFormat initEmailInfo() {

		info.setContent("I love Soso for 1314");
		return info;
	}
	public static void main(String[] args) throws Exception {
		AccountActivateExample example=new AccountActivateExample();

		example.sendEmail();
		
	}
	
	
	
	
	private static final String CHECK_CODE = "checkCode";
	Properties prop = new Properties(); //配置文件读取�?
	/**
	 * �����ʻ���������
	 */
	public static String generateActivateLink(String userAcc) {
		return "localhost:8080"+"/activateAccount.action?account=" 
				+ userAcc + "&" + CHECK_CODE + "=" + generateCheckcode(userAcc);
	}
	
	/**
	 * �����������������
	 */
	public String generateResetPwdLink(String userAcc) {
		return "localhost:8080"+"/forwardResetPwd.action?account="
				+ userAcc +"&"+ CHECK_CODE+ "="+ generateCheckcode(userAcc);
	}
	
	/**
	 * ������֤�ʻ���MD5У����
	 * @param user  Ҫ������ʻ�
	 * @return ���û�����������Ϻ�ͨ��md5���ܺ��16���Ƹ�ʽ���ַ���
	 */
	public static String generateCheckcode(String userAcc) {
	
		String randomCode = "自定义一个随机函数，或�?从数据库取checkcode";
	
		return md5(userAcc+":"+randomCode);
	}
	
	/**
	 * ��֤У�����Ƿ��ע��ʱ���͵���֤��һ��
	 * @param user Ҫ������ʻ�
	 * @param checkcode ע��ʱ���͵�У����
	 * @return ���һ�·���true�����򷵻�false
	 */
	public static boolean verifyCheckcode(String userAcc,String checkcode) {
		String checkCode = checkcode;
		return generateCheckcode(userAcc).equals(checkCode);
	}

	private static String md5(String string) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
			md.update(string.getBytes());
			byte[] md5Bytes = md.digest();
			return bytes2Hex(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String bytes2Hex(byte[] byteArray)
	{
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++)
		{
			if(byteArray[i] >= 0 && byteArray[i] < 16)
			{
				strBuf.append("0");
			}
			strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));
		}
		return strBuf.toString();
	}

	

	
}