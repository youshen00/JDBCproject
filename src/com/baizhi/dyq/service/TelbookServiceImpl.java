package com.baizhi.dyq.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.baizhi.dyq.dao.PersonDaoImpl;
import com.baizhi.dyq.entity.Person;
import com.baizhi.dyq.util.JdbcUtil;

public class TelbookServiceImpl implements TelbookService{
	
	private PersonDaoImpl pd = new PersonDaoImpl();
	
	//添加联系人需要使用的业务方法
    public void regist(Person person){
    	//调用方法连接数据库
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			//手动提交事务
			conn.setAutoCommit(false);
			//调用dao方法实现添加业务
			pd.insertPerson(person);
			//提交业务
			conn.commit();
		} catch (Exception e) {
			//回滚业务
			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally{
			//释放资源
	    	JdbcUtil.closeAll(conn, null,null);
		}
    }
    
  	//修改联系人时需要调用的业务方法
  	public void changePersonMessage(Person person){
  		//建立连接
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			//手动提交
			conn.setAutoCommit(false);
			//调用dao方法
			pd.updatePerson(person);
			//提交事务
			conn.commit();
		} catch (Exception e) {
			//回滚事务
			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally{
			//关闭资源
	  		JdbcUtil.closeAll(conn, null, null);
		}
  		
  	}
    
	//通过Id查找联系人
	public Person getOnePerson(Integer id) {
		// 创建连接
		Connection conn = null;
		Person p = null;
		try {
			// 手动提交
			// 执行Dao方法
			p = pd.selectPerson(id);
			// 提交事务
			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			// 释放资源
			JdbcUtil.closeAll(conn, null, null);
		}
			
	}
	
    //获得所有的联系人的业务方法
    public List<Person> getAllPersons() {
		// 创建连接
		Connection conn = null;
		List<Person> list = null;
		try {
			conn = JdbcUtil.getConnection();
			// 手动提交
			// 执行Dao方法
			list = pd.selectAllPerson();
			// 提交事务
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			JdbcUtil.closeAll(conn, null, null);
		}
    }
    
    //根据联系人姓名查找联系人的业务方法
    public List<Person> getPersonByName(String name){
		// 创建连接
		Connection conn = null;
		List<Person> list = null;
		try {
			conn = JdbcUtil.getConnection();
			// 手动提交
			// 执行Dao方法
			list = pd.selectPersonName(name);
			// 提交事务
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			JdbcUtil.closeAll(conn, null, null);
		}
    }
    
    //根据手机号码查询相关的联系人的业务方法
    public List<Person> getPersonByMobile(String mobile){
		// 创建连接
		Connection conn = null;
		List<Person> list = null;
		try {
			conn = JdbcUtil.getConnection();
			// 手动提交
			// 执行Dao方法
			list = pd.selectPersonMobile(mobile);
			// 提交事务
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			JdbcUtil.closeAll(conn, null, null);
		}
    }
    
    //删除联系人时需要调用的业务方法
    public void dropPerson(Integer id){
		// 创建连接
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			// 手动提交
			conn.setAutoCommit(false);
			// 执行Dao方法
			pd.deletePerson(id);
			// 提交事务
			conn.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			JdbcUtil.closeAll(conn, null, null);
		}
    }
}
