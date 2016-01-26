package com.scut.fan.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 * 数据库链接类，用作所有数据库的操作
 * @author FAN
 *
 */
public class DBconn {

	public Connection conn = null;
	public PreparedStatement pst = null;
	
	/**
	 * 实例化一个连接类
	 * @param DBurl 数据库地址
	 * @param DriverName 数据库驱动名
	 * @param user 登录用户名
	 * @param password 登录密码
	 * @throws Exception 
	 */
	public DBconn(String DBurl,String DriverName,String user,String password) throws Exception {
		try {
			Class.forName(DriverName);//指定连接类型
			conn = DriverManager.getConnection(DBurl, user, password);//获取连接
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	/**
	 * 执行SQL语句
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql) throws SQLException{
		ResultSet ret = null;
		pst = conn.prepareStatement(sql);//准备执行语句
		ret =pst.executeQuery();
		return ret;
	}
	
	public int executeUpdate(String sql) throws SQLException{
		
		pst = conn.prepareStatement(sql);//准备执行语句
		int ret =pst.executeUpdate();
		return ret;
	}
	
	/**
	 * 关闭链接
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
