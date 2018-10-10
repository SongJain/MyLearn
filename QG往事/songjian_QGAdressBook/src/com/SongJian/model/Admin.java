package com.SongJian.model;

//管理员的表
public class Admin
{
	private int id;
	private String name;
	private String password;
	private String creatday;
	
	//创建管理员get set的方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatday() {
		return creatday;
	}
	public void setCreatday(String creatday) {
		this.creatday = creatday;
	}
	
	

}
