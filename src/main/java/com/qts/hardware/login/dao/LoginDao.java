package com.qts.hardware.login.dao;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.userroles.model.UserRoles;

public interface LoginDao
{
	public Users users(String username,String password);
	
	public UserRoles getRole(int id);
	
	public Department findByDeptId(Integer id);
	
}
