package com.baizhi.dyq.service;

import java.util.List;

import com.baizhi.dyq.entity.Person;

public interface TelbookService {
	
	//添加
	public void regist(Person person);
	
	//更改
	public void changePersonMessage(Person person);
	
	//按id查找
	public Person getOnePerson(Integer id);
	
	//查看全部
	public List<Person> getAllPersons();
	
	//按名字查找
	public List<Person> getPersonByName(String name);
	
	//按手机号查找
	public List<Person> getPersonByMobile(String mobile);
	
	//删除
	public void dropPerson(Integer id);
}
