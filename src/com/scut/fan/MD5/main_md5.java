package com.scut.fan.MD5;

public class main_md5 {
	public static void main(String[] args) {
		
		String newPassword = MD5.GetMD5Code("qq1234");
		String oldPasswoord=MD5.GetMD5Code("qq1234");
		if (newPassword.endsWith(oldPasswoord)){
			System.out.println("密码正确，旧密码的md5:"+oldPasswoord+"新密码的md5："+newPassword);
		}else{
			System.out.println("密码错误，旧密码的md5:"+oldPasswoord+"新密码的md5："+newPassword);
		}
		
		
		newPassword = MD5.GetMD5Code("qq1234");
		oldPasswoord=MD5.GetMD5Code("qq1235");
		if (newPassword.endsWith(oldPasswoord)){
			System.out.println("密码正确，旧密码的md5:"+oldPasswoord+"新密码的md5："+newPassword);
		}else{
			System.out.println("密码错误，旧密码的md5:"+oldPasswoord+"新密码的md5："+newPassword);
		}
	}
	

}
