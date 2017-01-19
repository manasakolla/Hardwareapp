package com.qts.hardware.department.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qts.hardware.department.dao.DeptAddDao;
import com.qts.hardware.department.model.Department;
import com.qts.hardware.department.service.DeptAddService;
@Service
public class DeptAddServiceImpl implements DeptAddService
{

	@Autowired
	private DeptAddDao deptadddao;
	
	 public void setDeptadddao(DeptAddDao deptadddao)
	 {
		this.deptadddao = deptadddao;
	 }
    @Transactional
	@Override
	public int save(Department departmentadd) 
	{
		
		return deptadddao.save(departmentadd);
	}
    @Transactional
	@Override
	public List<Department> list() 
	{    	
		return deptadddao.list();
	}
}
