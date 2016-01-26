package com.scut.fan.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 * ���ݿ������࣬�����������ݿ�Ĳ���
 * @author FAN
 *
 */
public class DBconn {

	public Connection conn = null;
	public PreparedStatement pst = null;
	
	/**
	 * ʵ����һ��������
	 * @param DBurl ���ݿ��ַ
	 * @param DriverName ���ݿ�������
	 * @param user ��¼�û���
	 * @param password ��¼����
	 * @throws Exception 
	 */
	public DBconn(String DBurl,String DriverName,String user,String password) throws Exception {
		try {
			Class.forName(DriverName);//ָ����������
			conn = DriverManager.getConnection(DBurl, user, password);//��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	/**
	 * ִ��SQL���
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql) throws SQLException{
		ResultSet ret = null;
		pst = conn.prepareStatement(sql);//׼��ִ�����
		ret =pst.executeQuery();
		return ret;
	}
	
	public int executeUpdate(String sql) throws SQLException{
		
		pst = conn.prepareStatement(sql);//׼��ִ�����
		int ret =pst.executeUpdate();
		return ret;
	}
	
	/**
	 * �ر�����
	 */
	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
