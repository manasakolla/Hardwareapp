package com.qts.hardware.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.devices.model.DevicesAdmin;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.reception.model.RecpDev;
import com.qts.hardware.reception.service.RecpDevService;
@Controller
public class RecpController
{
	@Autowired
	private SessionFactory sessionfactory;
	public void setSessionFactory(SessionFactory sessionfactory)
	    {
	        this.sessionfactory = sessionfactory;	       
	    }
	@Autowired
	private RecpDevService recpdevservice;
	
	  /*supervisor home page */

	 @RequestMapping(value="recphome",method=RequestMethod.GET)
	 public String home()
     {       	
		return "home/recphome";
     }
	 /*to repair device add*/	 
	 @RequestMapping(value="/adddeviceform", method=RequestMethod.GET)	  
	 public String deviceAddingForm( Model model)
	 {       
		 Session session=sessionfactory.openSession();
		 String hql="from DevicesAdmin";
		 Query query=session.createQuery(hql);
		 List<DevicesAdmin> devicesadmin=query.list();
		 model.addAttribute("devicesadmin", devicesadmin);
		 
		 String hqls="from Users";
		 Query querys=session.createQuery(hqls);
		 List<Users> users=querys.list();
		 model.addAttribute("users", users);
		 return "supervisor/adddevice";
	 }
	
	 @RequestMapping(value="/adddevice",method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute RecpDev recpadddev,HttpServletRequest request,HttpServletResponse response,Model model ) throws Exception 
	  {				 
          recpdevservice.save(recpadddev);        
		  return new ModelAndView("supervisor/recpsuccess");		  
	  }
	 
	 /* devices list */	 
	 
	 @RequestMapping(value="/deviceslist",method=RequestMethod.GET)
	 public String list(Model model)
	 {
		 model.addAttribute("deviceslist",recpdevservice.list());
		 return "supervisor/deviceslist";		 
	 }
	 /*view list*/
	 @RequestMapping(value="/viewcustomer",method=RequestMethod.GET)
	 public String viewCustomer(Model model)
	 {
		 model.addAttribute("viewcustomer", recpdevservice.findbycustId(2));
		 return "supervisor/viewcustomer";
	 }
	 /*@RequestMapping(value="/editcustomer",method=RequestMethod.GET)
	 public String edit(HttpServletRequest request,HttpServletResponse response,Model model)
	 {
		// model.addAttribute("editcustomer", recpdevservice.update(recpDev));
		 model.addAttribute(" ", " ");
		return null;
	 }*/
}