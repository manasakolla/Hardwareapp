package com.qts.hardware.employee.service;

import java.util.List;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.dept.model.Dept;
import com.qts.hardware.login.model.Users;

public interface EmpAddService
{
	 public int save(Users empadd);
	 public List<Users> list();
	 public Users getbyRowId(int id);
	/* public List<Dept> FindAlldeptlists(Department department);*/
}
