package com.qts.hardware.dept.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class Dept
{
	private int id;
	
	private String name;
	
	private String role_name;

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

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

	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.role_name = role_name;
	}

	public Dept() {
		super();
	}
}
