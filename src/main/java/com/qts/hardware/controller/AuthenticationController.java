package com.qts.hardware.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.login.service.Loginservice;
@Controller
public class AuthenticationController extends HttpServlet
{

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Loginservice loginServc;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;	       
    }
	
    /*login form*/
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm()
	{		
		return "login/login";
	}
    
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute Users user,HttpServletRequest request,HttpServletResponse response,Model model)throws Exception
	{
		Users currentUser=loginServc.users(user.getUsername(), user.getPassword());
		model.addAttribute("message","you are Successfully logged in");
		if(currentUser!=null)
		{			
		    HttpSession session=request.getSession(false);
		    if(session!=null)
		    {
		    	session.invalidate();
		    }
		    session=request.getSession(true);		    
		    session.setAttribute("currentUser", currentUser);
		    Integer deptId=currentUser.getDeptId();
		    if(deptId != null)
		    {
		    	Department department=loginServc.findByDeptId(deptId);
		    	session.setAttribute("dept", department);
		    }		     
		    if(session.isNew())		    
		    {		    	
			    model.addAttribute("message", "The new session is created");
		    }
		    else
		    {		    	
			    request.getRequestDispatcher("login.html").include(request, response);			  
		    }		
		}
		else
		{
			return "login/login";
		}		    			    
		return "home/home";
	}
}