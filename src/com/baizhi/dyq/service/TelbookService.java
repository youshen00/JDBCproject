package com.baizhi.dyq.service;

import java.util.List;

import com.baizhi.dyq.entity.Person;

public interface TelbookService {
	
	//���
	public void regist(Person person);
	
	//����
	public void changePersonMessage(Person person);
	
	//��id����
	public Person getOnePerson(Integer id);
	
	//�鿴ȫ��
	public List<Person> getAllPersons();
	
	//�����ֲ���
	public List<Person> getPersonByName(String name);
	
	//���ֻ��Ų���
	public List<Person> getPersonByMobile(String mobile);
	
	//ɾ��
	public void dropPerson(Integer id);
}
