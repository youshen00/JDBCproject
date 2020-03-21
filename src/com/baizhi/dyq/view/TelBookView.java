package com.baizhi.dyq.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.baizhi.dyq.entity.Person;
import com.baizhi.dyq.service.TelbookService;
import com.baizhi.dyq.service.TelbookServiceImpl;

public class TelBookView {
	private Scanner sc = new Scanner(System.in);
	private TelbookService service = new TelbookServiceImpl();
	
	public  void showMainView(){
		while(true){
			System.out.println("***************��ӭ����ͨѶ¼***************");
			System.out.println("1.��ʾ������ϵ��     2.������������ϵ��     3.�����������ϵ��");
			System.out.println("4.�����ϵ��            5.ɾ����ϵ��                6.�޸���ϵ����Ϣ");
			System.out.println("7.�˳�");
			System.out.println("��ѡ�������");
			int selected = sc.nextInt();
			requestDispatcher(selected);
		}
	}
	
	public void  requestDispatcher(int selected) {
		try {
			switch(selected){
				case 1:{ showAllPerson(); break;}
				case 2:{ showPersonsByName(); break;}
				case 3:{ showPersonsByMobil();break;}
				case 4:{ addPerson(); break;}
				case 5:{ dropPerson(); break;}
				case 6:{changePersonMessage(); break;}
				case 7:{ 
					System.out.println("--------------------ллʹ��,�ټ�------------------");
					System.exit(0); 
					break;
				}
				default:{
					throw new Exception("��������뿼������ѡ��");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	//�û�ѡ����1,��ʾ������ϵ��
	public void  showAllPerson() {
		//����service�Ĳ�ѯ����,��ѯ���е���ϵ��
      List<Person>  list=service.getAllPersons();
      //���ñ���ķ�����ʾ��ϵ����Ϣ
      showPersons(list);
	}
	//ֻ�����������������ã��ñ����ʽ��ʾlist���������ϵ����Ϣ
	private void showPersons(List<Person> list) {
		System.out.println("Id\tName\t  Mobile  \t  Telphone  \t    Email    \t  City  \t  Birthday  ");
		for(Person p:list){
			System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getMoblie()+"\t"+p.getTelphone()+"\t"+p.getEmail()+"\t"+p.getCity()+"\t"+p.getBirthday());
	    }
	}
    
	//�û�ѡ����2,��������ѯ��ϵ��,����ģ����ѯ
   public void showPersonsByName() {
	   System.out.println("��������Ҫ��ѯ����ϵ������������ģ����ѯ����");
	   String name=sc.next();
	   //����service������ѯ�������
	   List<Person>  list=service.getPersonByName(name);
	    //���ñ���ķ�����ʾ��ϵ����Ϣ
       showPersons(list);
   }
   
   //�û�ѡ����3,���ֻ���ѯ��ϵ��,����ģ����ѯ
	public void showPersonsByMobil() {
		 System.out.println("��������Ҫ��ѯ����ϵ���ֻ����루����ģ����ѯ����");
		 String mobile=sc.next();
		 //����service������ѯ�������
		List<Person>  list=service.getPersonByMobile(mobile);
	    //���ñ���ķ�����ʾ��ϵ����Ϣ
		showPersons(list);
	}
    
	//�û�ѡ����4,�����ϵ��,�����û����ظ�
    public void addPerson() {
    	System.out.println("��������ϵ��������");
    	String name=sc.next();
    	System.out.println("��������ϵ���ֻ����룺");
    	String mobile=sc.next();
    	System.out.println("��������ϵ���������룺");
    	String telphone=sc.next();
    	System.out.println("��������ϵ��email��");
    	String email=sc.next();
    	System.out.println("��������ϵ�˵�ַ��");
    	String city=sc.next();
    	System.out.println("����������(1980-6-23):");
    	String date=sc.next();
    	SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
    	java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	//����service��regist()����
    	Person person = new Person(null,name,mobile,telphone,email,city,utilDate);
    	TelbookServiceImpl tle = new TelbookServiceImpl();
    	tle.regist(person);
    	System.out.println("�����ϵ�˳ɹ���������");
    }
    
    //�û�ѡ����5,ɾ����ϵ��,��Ҫ������ϵ�˵�id
    public void dropPerson() {
		System.out.println("��������Ҫɾ������ϵ�˵�id��");
		int id=sc.nextInt();	
		//����service�ķ���ɾ����ϵ��
		TelbookServiceImpl tel = new TelbookServiceImpl();
		tel.dropPerson(id);
		service.dropPerson(id);
		System.out.println("-----------ɾ���ɹ�----------");
    }
    //�û�ѡ����6
    //������Ҫ�û����뱻�޸��û���id,�����û���Ϣ��ʾ����Ļ��.
    //Ŀǰ�޸���ϵ��ֻ��ȫ���޸�,���������id���������ֵ
    public void changePersonMessage() {
		System.out.println("��������Ҫ�޸ĵ���ϵ�˵ı��(id):	");
		int id=sc.nextInt();	
		//����service�ĸ���id��ѯ��ϵ�˷���,�����ϵ�˾�����Ϣ������ʾ
		Person  p=service.getOnePerson(id); 
		System.out.println("��Ҫ�޸ĵ���ϵ�˾�����Ϣ����:");
		System.out.println("Id\tName\t  Mobile  \t  Telphone  \t    Email    \t  City  \t  Birthday  ");
		System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getMoblie()+"\t"+p.getTelphone()+"\t"+p.getEmail()+"\t"+p.getCity()+"\t"+p.getBirthday());
		//�û������޸���Ϣ
		System.out.println("��������ϵ��������");
    	String name=sc.next();
    	System.out.println("��������ϵ���ֻ����룺");
    	String mobile=sc.next();
    	System.out.println("��������ϵ���������룺");
    	String telphone=sc.next();
    	System.out.println("��������ϵ��email��");
    	String email=sc.next();
    	System.out.println("��������ϵ�˵�ַ��");
    	String city=sc.next();
    	System.out.println("����������(1980-6-23):");
    	String date=sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Person person = new Person(id,name,mobile,telphone,email,city,utilDate);
    	//����service����޸���ϵ�˵ķ���
		TelbookServiceImpl tel = new TelbookServiceImpl();
		tel.changePersonMessage(person);
		
		System.out.println("-----------�޸ĳɹ�----------");
    }
}
