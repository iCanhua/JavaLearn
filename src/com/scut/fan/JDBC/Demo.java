package com.scut.fan.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {


	public static void main(String[] args)  {
		
		String url = "jdbc:mysql://localhost/account?characterEncoding=utf-8";
		String name = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "qq1234";
		DBconn db = null;

		/**
		 * ����hos_info��isInUse
		 */
//		try {
//			db = new DBconn(url,name,user,password);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}//����DBconn����
//		
//		try{
//		String sql="SELECT sunshine.account_info.organization FROM sunshine.account_info;";
//		ResultSet ret = db.executeQuery(sql);//ִ����䣬�õ������
//		int i=1;
//		while (ret.next()) {
//			String organization = ret.getString(1).trim();
//			String sql2;
//			sql2="UPDATE sunshine.hos_info SET sunshine.hos_info.isInUse='1' WHERE  sunshine.hos_info.organization = '"+organization+"' ;";
//			db.executeUpdate(sql2);
//			System.out.println("�ɹ����£�"+i+""+organization);
//			i++;
//		}
//		
//		ret.close();
//		db.close();//�ر�����
//		}catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		
		
		/**
		 * ɸѡ����
		 */
//		try {
//			String sql = "select  hos_info.accNumber,hos_info.organization,account_set.user_name,account_set.email,account_set.telephone,account_set.mobilephone,account_set.faxes "+ 
//					"from account_set,hos_info WHERE account_set.organization_old=hos_info.organization";//SQL���
//			ResultSet ret = db.executeQuery(sql);//ִ����䣬�õ������
//			
//			while (ret.next()) {
//				String accNumber= ret.getString(1).trim();
//				String organization = ret.getString(2).trim();
//				String user_name = ret.getString(3).trim();
//				String email = ret.getString(4).trim();
//				String telephone=ret.getString(5).trim();
//				String mobilephone = ret.getString(6).trim();
//				String faxes = ret.getString(7).trim();
//				String sql2;
//				
//				System.out.println("�ʺţ�"+accNumber+"\t"+"��֯��"+organization
//									+"\t"+"�û�:"+user_name+"\t"+"����:"+email+"\t"+"�绰:"+telephone+"\t"
//									+"�ֻ�:"+mobilephone+"\t"+"����:"+faxes);
//				System.out.println("��������"+ret.getRow());
//				
//				sql2="INSERT INTO account_info (account_info.acc_number,account_info.organization,account_info.user_name,account_info.email,account_info.telephone,account_info.mobilephone,account_info.faxes) VALUES('"
//				+accNumber+"','"+organization+"','"+user_name+"','"+email+"','"+telephone+"','"+mobilephone+"','"+faxes+"')";
//				
//				db.executeUpdate(sql2);
//			}//��ʾ����
//			
//			
//			ret.close();
//			db.close();//�ر�����
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
