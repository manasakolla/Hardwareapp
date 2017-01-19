package com.qts.hardware.department.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qts.hardware.department.dao.DeptAddDao;
import com.qts.hardware.department.model.Department;

@Repository
public class DeptAddDaoImpl implements DeptAddDao 
{
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int save(Department departmentadd)
	{
		 Integer i = (Integer)hibernatetemplate.save(departmentadd);
	     return i;
	}
    @Override
	public List<Department> list()
	{
		Session session=sessionFactory.openSession();
		  String hql="from Department";		  
		  Query query=session.createQuery(hql);
		  List<Department> departmentadds=query.list();
	     return departmentadds;	
	}
}
