package com.qts.hardware.userroles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_roles")
public class UserRoles
{
	@Id
	@GeneratedValue
	private int id;
	private String roles;
   
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getRoles()
	{
		return roles;
	}
	public void setRoles(String roles)
	{
		this.roles = roles;
	}
	
}
