package com.qts.hardware.login.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.login.dao.LoginDao;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.login.service.Loginservice;
import com.qts.hardware.userroles.model.UserRoles;
@Service
public class LoginServiceImpl implements Loginservice
{
	@Autowired
	private LoginDao recplogindao;
	public void setRecpLoginDao(LoginDao recplogindao)
	{
		this.recplogindao=recplogindao;
	}

	@Transactional
	@Override
	public Users users(String username, String password)
	{
		return recplogindao.users(username, password);
	}

	@Transactional
	@Override
	public UserRoles getRole(int id)
	{
		return recplogindao.getRole(id);
	}

	/*@Transactional
	@Override
	public Department findByRole_name(String role_name) 
	{
		return recplogindao.findByRole_name(role_name);
	}*/

	@Transactional
	@Override
	public Department findByDeptId(Integer id)
	{
		return recplogindao.findByDeptId(id);
	}	
}
