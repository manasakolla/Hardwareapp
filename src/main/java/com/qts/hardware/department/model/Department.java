package com.qts.hardware.department.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="role_name")
	private String role_name;
	@Column(name="name")
	private String name;
	@Column(name="descr")
	private String description;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}	
	public String getRole_name()
	{
		return role_name;
	}
	public void setRole_name(String role_name)
	{	
		this.role_name = role_name;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
		
}
