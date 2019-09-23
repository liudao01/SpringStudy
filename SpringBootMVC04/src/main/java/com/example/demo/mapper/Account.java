package com.example.demo.mapper;


//mapper  映射  把实体类映射到表里
public class Account {
	private int id;
	private int age;
	private String loginName;
	private String password;
	private String nickName;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoacation() {
		return location;
	}
	public void setLoacation(String loacation) {
		this.location = loacation;
	}
	
	
}
