package com.qts.hardware.reception.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.reception.dao.RecpDevDao;
import com.qts.hardware.reception.model.RecpDev;
@Repository
public class RecpDevDaoImpl implements RecpDevDao
{
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int save(RecpDev recpadddev) 
	{		
		Integer j = (Integer)hibernatetemplate.save(recpadddev);
		return j;
	}

	@Override
	public List<RecpDev> list() 
	{
		Session session=sessionFactory.openSession();
		String hql="from RecpDev";
		Query query=session.createQuery(hql);
		List<RecpDev> recpadddevs=query.list();
		return recpadddevs;
	}

	@Override
	public RecpDev findbycustId(Integer id) 
	{
		Query query=(Query) sessionFactory.openSession().createQuery("from RecpDev where id=:id");
		query.setParameter("id", id);
		RecpDev recp = (RecpDev) query.uniqueResult();		
		return recp;
	}

	@Override
	public void update(RecpDev recpDev)
	{
		sessionFactory.openSession().update(recpDev);
		
	}
}
