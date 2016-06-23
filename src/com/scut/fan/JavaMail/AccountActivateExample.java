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
 * 生成帐户激活、重新设置密码的链接
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
	Properties prop = new Properties(); //閰嶇疆鏂囦欢璇诲彇鍣?
	/**
	 * 生成帐户激活链接
	 */
	public static String generateActivateLink(String userAcc) {
		return "localhost:8080"+"/activateAccount.action?account=" 
				+ userAcc + "&" + CHECK_CODE + "=" + generateCheckcode(userAcc);
	}
	
	/**
	 * 生成重设密码的链接
	 */
	public String generateResetPwdLink(String userAcc) {
		return "localhost:8080"+"/forwardResetPwd.action?account="
				+ userAcc +"&"+ CHECK_CODE+ "="+ generateCheckcode(userAcc);
	}
	
	/**
	 * 生成验证帐户的MD5校验码
	 * @param user  要激活的帐户
	 * @return 将用户名和密码组合后，通过md5加密后的16进制格式的字符串
	 */
	public static String generateCheckcode(String userAcc) {
	
		String randomCode = "鑷畾涔変竴涓殢鏈哄嚱鏁帮紝鎴栬?浠庢暟鎹簱鍙朿heckcode";
	
		return md5(userAcc+":"+randomCode);
	}
	
	/**
	 * 验证校验码是否和注册时发送的验证码一致
	 * @param user 要激活的帐户
	 * @param checkcode 注册时发送的校验码
	 * @return 如果一致返回true，否则返回false
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