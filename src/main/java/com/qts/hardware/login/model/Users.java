package com.qts.hardware.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="h_user")
public class Users
{
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="dept_id")
	private Integer deptId;	
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public Integer getId()
	{
		return id;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
