package com.baizhi.dyq.test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.baizhi.dyq.dao.PersonDaoImpl;
import com.baizhi.dyq.entity.Person;

public class PersonDaoTest {

	public static void main(String[] args) throws Exception{
		/*
		//插入操作
		//用户输入
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = sc.next();
		System.out.println("请输入手机号：");
		String mobile = sc.next();
		System.out.println("请输入电话：");
		String telphone = sc.next();
		System.out.println("请输入邮箱：");
		String email = sc.next();
		System.out.println("请输入地址：");
		String addr = sc.next();
		System.out.println("请输入日期（yyyy-MM-dd）：");
		String date = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(date);
		//传入对象
		Person person = new Person(null,name,mobile,telphone,email,addr,utilDate);
		//调用方法执行插入语句操作
		PersonDao personDao = new PersonDao();
		personDao.insertPerson(person);
		*/
		
		
		
		 //删除操作
		PersonDaoImpl personDao = new PersonDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入id：");
		Integer id = sc.nextInt();
		personDao.deletePerson(id);
		
		
		/*更改操作
		//用户输入
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入ID：");
		Integer id = sc.nextInt();
		System.out.println("请输入更改姓名：");
		String name = sc.next();
		System.out.println("请输入更改手机号：");
		String mobile = sc.next();
		System.out.println("请输入更改电话：");
		String telphone = sc.next();
		System.out.println("请输入更改邮箱：");
		String email = sc.next();
		System.out.println("请输入更改地址：");
		String addr = sc.next();
		System.out.println("请输入更改日期（yyyy-MM-dd）：");
		String date = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(date);
		//传入对象
		Person person = new Person(id,name,mobile,telphone,email,addr,utilDate);
		//调用方法执行插入语句操作
		PersonDao personDao = new PersonDao();
		personDao.updatePerson(person);
		*/
		
		/*查所有
		PersonDao personDao = new PersonDao();
		List<Person> list = personDao.selectPersons();
		for(Person p : list){
			System.out.println(p.toString());
		}
		*/
		
		/*
		//查一个
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入id");
		int n = sc.nextInt();
		PersonDao personDao = new PersonDao();
		Person p = personDao.selectAperson(n);
		System.out.println(p);
		*/
		

		/*
		//按名字查询
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入查询姓名:");
		String name = sc.next();
		PersonDaoImpl personDao = new PersonDaoImpl();
		List<Person> list = personDao.selectPersonName(name);
		for(Person p : list){
			System.out.println(p.toString());
		}
		*/
		
		/*
		//按电话号码查询
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入查询手机号码:");
		String mobile = sc.next();
		PersonDao personDao = new PersonDao();
		List<Person> list = personDao.selectPersonMobile(mobile);
		for(Person p : list){
			System.out.println(p.toString());
		}
		*/

	}

}
