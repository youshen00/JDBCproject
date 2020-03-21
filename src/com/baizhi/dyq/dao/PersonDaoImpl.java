package com.baizhi.dyq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.dyq.entity.Person;
import com.baizhi.dyq.util.JdbcUtil;

public class PersonDaoImpl implements PersonDao{
	
	//增加操作
	@Override
	public void insertPerson(Person p){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//连接数据库
			conn = JdbcUtil.getConnection();
			//创建statement
			String sql = "insert into person values(seq_person.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,p.getName());
			ps.setString(2,p.getMoblie());
			ps.setString(3,p.getTelphone());
			ps.setString(4,p.getEmail());
			ps.setString(5,p.getCity());
			java.sql.Date sqlDate= new java.sql.Date(p.getBirthday().getTime());
			ps.setDate(6,sqlDate);
			//执行增加操作
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.closeAll(null, ps, null);
		}
		
	}
	
	//修改操作
	@Override
	public void updatePerson(Person p){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//连接数据库
			conn = JdbcUtil.getConnection();
			//创建statement
			String sql = "update person set name=?,mobile=?,telphone=?,email=?,city=?,birthday=? where id =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,p.getName());
			ps.setString(2,p.getMoblie());
			ps.setString(3,p.getTelphone());
			ps.setString(4,p.getEmail());
			ps.setString(5,p.getCity());
			java.sql.Date sqlDate= new java.sql.Date(p.getBirthday().getTime());
			ps.setDate(6,sqlDate);
			ps.setInt(7,p.getId());
			//执行修改操作
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.closeAll(null, ps, null);
		}
		
	}
	
	//删除操作
	@Override
	public void deletePerson(int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 连接数据库
			conn = JdbcUtil.getConnection();
			// 创建statement
			String sql = "delete from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			//执行删除操作
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			// 释放资源
			JdbcUtil.closeAll(null, ps, null);
		}
		
	}
	
	//查找 全部操作
	@Override
	public List<Person> selectAllPerson() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Person> list = null;
		try {
			// 连接数据库
			conn = JdbcUtil.getConnection();
			// 创建statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person";
			ps = conn.prepareStatement(sql);
			// 执行删除操作
			rs  = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String telphone = rs.getString("telphone");
				String email = rs.getString("email");
				String city = rs.getString("city");
				java.util.Date birthday = rs.getDate("birthday");
				
				Person p = new Person(id,name,mobile,telphone,email,city,birthday);
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(null, ps,rs);
		}
	}
	
	//查一个
	@Override
	public Person selectPerson(int n) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		try {
			// 连接数据库
			conn = JdbcUtil.getConnection();
			// 创建statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, n);
			// 执行删除操作
			rs = ps.executeQuery();
			p = null;
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String telphone = rs.getString("telphone");
				String email = rs.getString("email");
				String city = rs.getString("city");
				java.util.Date birthday = rs.getDate("birthday");
				
				p = new Person(id,name,mobile,telphone,email,city,birthday);
		}
		return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			// 释放资源
			JdbcUtil.closeAll(null, ps, rs);
		}
	}
	
	//按名字查询
	@Override
	public List<Person> selectPersonName(String sname) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		List<Person> list = null;
		try {
			// 连接数据库
			conn = JdbcUtil.getConnection();
			// 创建statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person where name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ sname +"%");
			// 执行删除操作
			rs  = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String telphone = rs.getString("telphone");
				String email = rs.getString("email");
				String city = rs.getString("city");
				java.util.Date birthday = rs.getDate("birthday");
				
				Person p = new Person(id,name,mobile,telphone,email,city,birthday);
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			// 释放资源
			JdbcUtil.closeAll(null, ps, rs);
		}
	}
	
	//按号码查询
	@Override
	public List<Person> selectPersonMobile(String smobile) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Person> list = null;
		ResultSet rs = null;
		try {
			// 连接数据库
			conn = JdbcUtil.getConnection();
			// 创建statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person where mobile like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+smobile+"%");
			// 执行删除操作
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String telphone = rs.getString("telphone");
				String email = rs.getString("email");
				String city = rs.getString("city");
				java.util.Date birthday = rs.getDate("birthday");

				Person p = new Person(id, name, mobile, telphone, email, city,
						birthday);
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			JdbcUtil.closeAll(null, ps, rs);
		}
	}
}
