package com.scut.fan.MD5;

public class main_md5 {
	public static void main(String[] args) {
		
		String newPassword = MD5.GetMD5Code("qq1234");
		String oldPasswoord=MD5.GetMD5Code("qq1234");
		if (newPassword.endsWith(oldPasswoord)){
			System.out.println("������ȷ���������md5:"+oldPasswoord+"�������md5��"+newPassword);
		}else{
			System.out.println("������󣬾������md5:"+oldPasswoord+"�������md5��"+newPassword);
		}
		
		
		newPassword = MD5.GetMD5Code("qq1234");
		oldPasswoord=MD5.GetMD5Code("qq1235");
		if (newPassword.endsWith(oldPasswoord)){
			System.out.println("������ȷ���������md5:"+oldPasswoord+"�������md5��"+newPassword);
		}else{
			System.out.println("������󣬾������md5:"+oldPasswoord+"�������md5��"+newPassword);
		}
	}
	

}
