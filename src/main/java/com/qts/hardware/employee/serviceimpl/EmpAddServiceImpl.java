package com.qts.hardware.employee.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.dept.model.Dept;
import com.qts.hardware.employee.dao.EmpAddDao;
import com.qts.hardware.employee.service.EmpAddService;
import com.qts.hardware.login.model.Users;

@Service
public class EmpAddServiceImpl implements EmpAddService
{
	@Autowired
	private EmpAddDao empadddao;

	 public void setEmpAddDao(EmpAddDao empadddao)
	 {
	    this.empadddao = empadddao;
	 }
	 
	 @Transactional
	 @Override
	 public int save(Users empadd)
	 {
		return empadddao.save(empadd);
	 }
	 
	@Override
	public List<Users> list() 
	{		
		return empadddao.list();
	}

	@Override
	public Users getbyRowId(int id)
	{
		return empadddao.getbyRowId(id);
	}

	/*@Override
	public List<Dept> FindAlldeptlists(Department department) 
	{
		return empadddao.FindAlldeptlists(department);
	}*/
}
