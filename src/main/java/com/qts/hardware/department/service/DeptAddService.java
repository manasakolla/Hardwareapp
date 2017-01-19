package com.qts.hardware.department.service;

import java.util.List;

import com.qts.hardware.department.model.Department;
public interface DeptAddService
{
	 public int save(Department departmentadd);
	 public List<Department> list();
}
