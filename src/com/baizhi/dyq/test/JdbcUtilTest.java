package com.baizhi.dyq.test;

import java.sql.Connection;

import com.baizhi.dyq.util.JdbcUtil;

public class JdbcUtilTest {
	public static void main(String[] args){
		//≤‚ ‘¡¨Ω”
		Connection conn =JdbcUtil.getConnection();
		System.out.println(conn);
		
	}
}
