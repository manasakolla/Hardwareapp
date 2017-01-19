package com.qts.hardware.devices.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qts.hardware.devices.Dao.DeviceAddingDao;
import com.qts.hardware.devices.model.DevicesAdmin;

@Repository
public class DevicesaddDaoImpl implements DeviceAddingDao
{
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	   
	@Transactional
	public int save(DevicesAdmin devicesadd)
	{
		
		//Map<String, ClassMetadata> map=sessionFactory.getAllClassMetadata();
		 Integer i = (Integer)hibernatetemplate.save(devicesadd);		 
	     return i;		 
	}

	@Override
	public List<DevicesAdmin> list() 
	{
      Session session=sessionFactory.openSession();
	  String hql="from DevicesAdmin";
	  Query query=session.createQuery(hql);
	  List<DevicesAdmin> devicesadds=query.list();
		return devicesadds;
	}

	@Override
	public void delete(DevicesAdmin devicesadd) 
	{
		sessionFactory.getCurrentSession().createQuery("delete from devicesadd where id="+devicesadd.getId()).executeUpdate();
	}
	
	/*@Override
	public void deleteDevicesadd(int id)
	{
		Devicesadd devicesadd=getDevicesadd(id);
		 if (devicesadd != null)
	      getCurrentSession().delete(devicesadd);			 
	}
	public Devicesadd getDevicesadd(int id) 
	{
		Devicesadd devicesadd = (Devicesadd) getCurrentSession().get(Devicesadd.class, id);
		return devicesadd;
	}
	private Session getCurrentSession()
	{		
		return sessionFactory.getCurrentSession();

	}
	@Override
	public void updateDevicesadd(Devicesadd devicesadd)
	{
		Devicesadd devicesaddToUpdate = getDevicesadd(devicesadd.getId());
		        devicesaddToUpdate.setName(devicesadd.getName());
		        devicesaddToUpdate.setDescription(devicesadd.getDescription());
		        getCurrentSession().update(devicesaddToUpdate);
		
	}*/
}
