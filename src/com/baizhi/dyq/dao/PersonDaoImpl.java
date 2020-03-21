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
	
	//���Ӳ���
	@Override
	public void insertPerson(Person p){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//�������ݿ�
			conn = JdbcUtil.getConnection();
			//����statement
			String sql = "insert into person values(seq_person.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,p.getName());
			ps.setString(2,p.getMoblie());
			ps.setString(3,p.getTelphone());
			ps.setString(4,p.getEmail());
			ps.setString(5,p.getCity());
			java.sql.Date sqlDate= new java.sql.Date(p.getBirthday().getTime());
			ps.setDate(6,sqlDate);
			//ִ�����Ӳ���
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			//�ͷ���Դ
			JdbcUtil.closeAll(null, ps, null);
		}
		
	}
	
	//�޸Ĳ���
	@Override
	public void updatePerson(Person p){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//�������ݿ�
			conn = JdbcUtil.getConnection();
			//����statement
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
			//ִ���޸Ĳ���
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			//�ͷ���Դ
			JdbcUtil.closeAll(null, ps, null);
		}
		
	}
	
	//ɾ������
	@Override
	public void deletePerson(int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// �������ݿ�
			conn = JdbcUtil.getConnection();
			// ����statement
			String sql = "delete from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			//ִ��ɾ������
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			// �ͷ���Դ
			JdbcUtil.closeAll(null, ps, null);
		}
		
	}
	
	//���� ȫ������
	@Override
	public List<Person> selectAllPerson() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Person> list = null;
		try {
			// �������ݿ�
			conn = JdbcUtil.getConnection();
			// ����statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person";
			ps = conn.prepareStatement(sql);
			// ִ��ɾ������
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
	
	//��һ��
	@Override
	public Person selectPerson(int n) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		try {
			// �������ݿ�
			conn = JdbcUtil.getConnection();
			// ����statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, n);
			// ִ��ɾ������
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
			// �ͷ���Դ
			JdbcUtil.closeAll(null, ps, rs);
		}
	}
	
	//�����ֲ�ѯ
	@Override
	public List<Person> selectPersonName(String sname) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		List<Person> list = null;
		try {
			// �������ݿ�
			conn = JdbcUtil.getConnection();
			// ����statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person where name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ sname +"%");
			// ִ��ɾ������
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
			// �ͷ���Դ
			JdbcUtil.closeAll(null, ps, rs);
		}
	}
	
	//�������ѯ
	@Override
	public List<Person> selectPersonMobile(String smobile) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Person> list = null;
		ResultSet rs = null;
		try {
			// �������ݿ�
			conn = JdbcUtil.getConnection();
			// ����statement
			String sql = "select id,name,mobile,telphone,email,city,birthday from person where mobile like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+smobile+"%");
			// ִ��ɾ������
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
			// �ͷ���Դ
			JdbcUtil.closeAll(null, ps, rs);
		}
	}
}
