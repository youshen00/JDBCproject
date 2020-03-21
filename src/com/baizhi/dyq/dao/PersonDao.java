package com.baizhi.dyq.dao;

import java.util.List;

import com.baizhi.dyq.entity.Person;

 public interface PersonDao {
	//���
	public void insertPerson(Person p);
	
	//�޸Ĳ���
	public void updatePerson(Person p);
	
	//ɾ������
	public void deletePerson(int no);
	
	//��ȫ��
	public List<Person> selectAllPerson();
	
	//��һ��
	public Person selectPerson(int n);
	
	//�����ֲ�
	public List<Person> selectPersonName(String sname);
	
	//�������
	public List<Person> selectPersonMobile(String smobile);
}
