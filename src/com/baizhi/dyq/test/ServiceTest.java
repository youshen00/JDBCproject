package com.baizhi.dyq.test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.baizhi.dyq.entity.Person;
import com.baizhi.dyq.service.TelbookServiceImpl;

public class ServiceTest {

	public static void main(String[] args) throws Exception{
		TelbookServiceImpl ts = new TelbookServiceImpl();
		
		/*
		//�������
		//�û�����
		Scanner sc = new Scanner(System.in);
		System.out.println("������������");
		String name = sc.next();
		System.out.println("�������ֻ��ţ�");
		String mobile = sc.next();
		System.out.println("������绰��");
		String telphone = sc.next();
		System.out.println("���������䣺");
		String email = sc.next();
		System.out.println("�������ַ��");
		String addr = sc.next();
		System.out.println("���������ڣ�yyyy-MM-dd����");
		String date = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(date);
		//�������
		Person person = new Person(null,name,mobile,telphone,email,addr,utilDate);
		//���÷���ִ�в���������
		ts.regist(person);
		*/
		
		/*���Ĳ���
		//�û�����
		Scanner sc = new Scanner(System.in);
		System.out.println("������ID��");
		Integer id = sc.nextInt();
		System.out.println("���������������");
		String name = sc.next();
		System.out.println("����������ֻ��ţ�");
		String mobile = sc.next();
		System.out.println("��������ĵ绰��");
		String telphone = sc.next();
		System.out.println("������������䣺");
		String email = sc.next();
		System.out.println("��������ĵ�ַ��");
		String addr = sc.next();
		System.out.println("������������ڣ�yyyy-MM-dd����");
		String date = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(date);
		//�������
		Person person = new Person(id,name,mobile,telphone,email,addr,utilDate);
		//���÷���ִ�в���������
		ts.changePersonMessage(person);
		*/
		
		/*������
		List<Person> list = ts.getAllPersons();
		for(Person p : list){
			System.out.println(p.toString());
		}
		*/
		
		/*
		//��һ��
		Scanner sc = new Scanner(System.in);
		System.out.println("������id");
		int n = sc.nextInt();
		Person p = ts.getOnePerson(n);
		System.out.println(p);
		*/
		
		/*
		//�����ֲ�ѯ
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ѯ����:");
		String name = sc.next();
		List<Person> list = ts.getPersonByName(name);
		for(Person p : list){
			System.out.println(p.toString());
		}
		*/
		
		/*
		//���绰�����ѯ
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ѯ�ֻ�����:");
		String mobile = sc.next();
		List<Person> list = ts.getPersonByMobile(mobile);
		for(Person p : list){
			System.out.println(p.toString());
		}
		*/
		
		
	}

}
