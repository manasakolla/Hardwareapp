package com.qts.hardware.login.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.login.dao.LoginDao;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.userroles.model.UserRoles;
@Repository
public class LoginDaoImpl implements LoginDao
{
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
    public void setHibernatetemplate(HibernateTemplate hibernatetemplate)
	{
		this.hibernatetemplate = hibernatetemplate;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
        this.sessionFactory = sessionFactory;
    }
	 private Session getCurrentSession()
	 {
	        return sessionFactory.getCurrentSession();
	 }
	@Override
	public Users users(String username, String password)
	{
		Session session = sessionFactory.openSession();
		Users user =null;
	  try
		{
		  Query query=(Query) sessionFactory.openSession().createQuery("from Users where username=:username and password=:password");
		   query.setParameter("username", username);
		   query.setParameter("password", password);
			user = (Users) query.uniqueResult();			 
		    		        
	    }
	catch(Exception e)
	{
		e.printStackTrace();
	}		
	return user;
    }
	@Override
	public UserRoles getRole(int id)
	{
		 UserRoles role = (UserRoles) getCurrentSession().load(UserRoles.class, id);
		 
		return role;
	}
	public List<String> getRoles(Integer role)
	{
		List<String> roles = new ArrayList<String>();
		if(role.intValue()==8)
		{
			roles.add("USERROLES_ADMIN");
			 roles.add("USERROLES_EMPLOYEE");
	            roles.add("USERROLES_RECEPTION");
	        } 
	        else if (role.intValue() == 10) 
	        {
	            roles.add("USERROLES_RECEPTION");
	            roles.add("USERROLES_ADMIN");
	        }
	        else if(role.intValue()==12)
	        {
	        	roles.add("USERROLES_ADMIN");
	        }
	        return roles;
	}	
	public Department findByDeptId(Integer id)
	{
		//Session session = sessionFactory.openSession();
		Query query=(Query) sessionFactory.openSession().createQuery("from Department where id=:id");
		query.setParameter("id", id);
		Department department = (Department) query.uniqueResult();
		//Department department=(Department) hibernatetemplate.find("from Department where id=?",id);				
		return department;
	}
	/*@Override
	public Department findByRole_name(String role_name)
	{
		Query query=(Query) sessionFactory.openSession().createQuery("from Department where role_name=:role_name");
		query.setParameter("role_name", );
		Department department = (Department) query.uniqueResult();
		return null;
	}*/
}