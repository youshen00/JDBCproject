package com.baizhi.dyq.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.baizhi.dyq.dao.PersonDaoImpl;
import com.baizhi.dyq.entity.Person;
import com.baizhi.dyq.util.JdbcUtil;

public class TelbookServiceImpl implements TelbookService{
	
	private PersonDaoImpl pd = new PersonDaoImpl();
	
	//�����ϵ����Ҫʹ�õ�ҵ�񷽷�
    public void regist(Person person){
    	//���÷����������ݿ�
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			//�ֶ��ύ����
			conn.setAutoCommit(false);
			//����dao����ʵ�����ҵ��
			pd.insertPerson(person);
			//�ύҵ��
			conn.commit();
		} catch (Exception e) {
			//�ع�ҵ��
			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally{
			//�ͷ���Դ
	    	JdbcUtil.closeAll(conn, null,null);
		}
    }
    
  	//�޸���ϵ��ʱ��Ҫ���õ�ҵ�񷽷�
  	public void changePersonMessage(Person person){
  		//��������
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			//�ֶ��ύ
			conn.setAutoCommit(false);
			//����dao����
			pd.updatePerson(person);
			//�ύ����
			conn.commit();
		} catch (Exception e) {
			//�ع�����
			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally{
			//�ر���Դ
	  		JdbcUtil.closeAll(conn, null, null);
		}
  		
  	}
    
	//ͨ��Id������ϵ��
	public Person getOnePerson(Integer id) {
		// ��������
		Connection conn = null;
		Person p = null;
		try {
			// �ֶ��ύ
			// ִ��Dao����
			p = pd.selectPerson(id);
			// �ύ����
			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			// �ͷ���Դ
			JdbcUtil.closeAll(conn, null, null);
		}
			
	}
	
    //������е���ϵ�˵�ҵ�񷽷�
    public List<Person> getAllPersons() {
		// ��������
		Connection conn = null;
		List<Person> list = null;
		try {
			conn = JdbcUtil.getConnection();
			// �ֶ��ύ
			// ִ��Dao����
			list = pd.selectAllPerson();
			// �ύ����
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// �ͷ���Դ
			JdbcUtil.closeAll(conn, null, null);
		}
    }
    
    //������ϵ������������ϵ�˵�ҵ�񷽷�
    public List<Person> getPersonByName(String name){
		// ��������
		Connection conn = null;
		List<Person> list = null;
		try {
			conn = JdbcUtil.getConnection();
			// �ֶ��ύ
			// ִ��Dao����
			list = pd.selectPersonName(name);
			// �ύ����
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// �ͷ���Դ
			JdbcUtil.closeAll(conn, null, null);
		}
    }
    
    //�����ֻ������ѯ��ص���ϵ�˵�ҵ�񷽷�
    public List<Person> getPersonByMobile(String mobile){
		// ��������
		Connection conn = null;
		List<Person> list = null;
		try {
			conn = JdbcUtil.getConnection();
			// �ֶ��ύ
			// ִ��Dao����
			list = pd.selectPersonMobile(mobile);
			// �ύ����
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// �ͷ���Դ
			JdbcUtil.closeAll(conn, null, null);
		}
    }
    
    //ɾ����ϵ��ʱ��Ҫ���õ�ҵ�񷽷�
    public void dropPerson(Integer id){
		// ��������
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			// �ֶ��ύ
			conn.setAutoCommit(false);
			// ִ��Dao����
			pd.deletePerson(id);
			// �ύ����
			conn.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// �ͷ���Դ
			JdbcUtil.closeAll(conn, null, null);
		}
    }
}
