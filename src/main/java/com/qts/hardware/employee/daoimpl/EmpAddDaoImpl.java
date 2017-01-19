package com.qts.hardware.employee.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.dept.model.Dept;
import com.qts.hardware.employee.dao.EmpAddDao;
import com.qts.hardware.login.model.Users;
@Repository
public class EmpAddDaoImpl implements EmpAddDao
{

	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Users empadd) 
	{
		Integer i = (Integer)hibernatetemplate.save(empadd);
		return i;
	}

	@Override
	public List<Users> list()
	{
		 Session session=sessionFactory.openSession();
		 String hql="from Users";
		 Query query=session.createQuery(hql);
		 List<Users> user=query.list();
		 return user;
	}

	@Override
	public Users getbyRowId(int id)
	{
		Session session=sessionFactory.openSession();
		Users user=(Users)session.load(Users.class, id);
		return user;
	}

	/*@Override
	public List<Dept> FindAlldeptlists(Department department)
	{
		try
		{
			List<Dept> results=new ArrayList<Dept>();
			for(Department department2:department.getDepartments()) results.add(new Dept(department2.getId(),department2.getName()));
			return results;			
		}
		catch(Exception e)
		{
			return null;
		}
	}*/

	
}
