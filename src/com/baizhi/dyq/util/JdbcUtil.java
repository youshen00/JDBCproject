package com.baizhi.dyq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import sun.security.timestamp.TSRequest;

public class JdbcUtil {
	private static Properties pro = new Properties();
	static{
		InputStream is = null;
		try {
			is = JdbcUtil.class.getResourceAsStream("/com/baizhi/dyq/conf/jdbc.properties");
			pro.load(is);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final ThreadLocal<Connection> tol = new ThreadLocal<>();
	//连接方法
	public static Connection getConnection(){
		Connection conn = tol.get();
		if(conn == null){
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			String url = pro.getProperty("url");
			String driverClass = pro.getProperty("driverClass");
			try {
				//注册驱动
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url,user,password);
				tol.set(conn);
				return conn;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return conn;
	}
	
	
	//释放资源方法
	public static void closeAll(Connection conn,Statement st, ResultSet rs){
		if (rs != null){
			try {
				 rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (st != null){
			try {
				 st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				 {
					conn.close(); 
					tol.remove();
				}
									
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

