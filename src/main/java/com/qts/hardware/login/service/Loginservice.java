package com.qts.hardware.login.service;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.userroles.model.UserRoles;

public interface Loginservice
{
	public Users users(String username,String password);
	
	public UserRoles getRole(int id);
	
	public Department findByDeptId(Integer id);
}
