package com.baizhi.dyq.dao;

import java.util.List;

import com.baizhi.dyq.entity.Person;

 public interface PersonDao {
	//添加
	public void insertPerson(Person p);
	
	//修改操作
	public void updatePerson(Person p);
	
	//删除操作
	public void deletePerson(int no);
	
	//查全部
	public List<Person> selectAllPerson();
	
	//查一个
	public Person selectPerson(int n);
	
	//按名字查
	public List<Person> selectPersonName(String sname);
	
	//按号码查
	public List<Person> selectPersonMobile(String smobile);
}
