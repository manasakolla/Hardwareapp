package com.qts.hardware.department.dao;

import java.util.List;

import com.qts.hardware.department.model.Department;

public interface DeptAddDao 
{
	public int save(Department departmentadd);
	 public List<Department> list();
}
