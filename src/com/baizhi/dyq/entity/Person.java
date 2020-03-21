package com.baizhi.dyq.entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	private Integer id;
	private String name;
	private String moblie;
	private String telphone;
	private String email;
	private String city;
	private java.util.Date birthday;
	
	public Person(){}
	public Person(Integer id, String name, String moblie, String telphone,
			String email, String city, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.moblie = moblie;
		this.telphone = telphone;
		this.email = email;
		this.city = city;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoblie() {
		return moblie;
	}
	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", moblie=" + moblie
				+ ", telphone=" + telphone + ", email=" + email + ", city="
				+ city + ", birthday=" + birthday + "]";
	}
		
}
