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
import com.qts.hardware.department.service.DeptAddService;
import com.qts.hardware.dept.model.Dept;
import com.qts.hardware.devices.model.DevicesAdmin;
import com.qts.hardware.devices.service.DeviceAddingService;
import com.qts.hardware.employee.service.EmpAddService;
import com.qts.hardware.login.model.Users;
import com.qts.hardware.login.service.Loginservice;


@Controller(value="HomeController")
public class HomeController 
{
	@Autowired
	private DeviceAddingService deviceaddservice;
	
	@Autowired
	private DeptAddService deptaddservice;
	
	@Autowired
	private EmpAddService empaddservice;
	
	@Autowired
	private Loginservice recploginservice;
	
	@Autowired
	private SessionFactory sessionfactory;
	public void setSessionFactory(SessionFactory sessionfactory)
	    {
	        this.sessionfactory = sessionfactory;	       
	    }	
	
	 /* home page   */
	@RequestMapping(value="/",method=RequestMethod.GET)
	 public String loginForm()
     {       	
		return "login/login";
     }
	
	
	 @RequestMapping(value="profile",method=RequestMethod.GET)
	 public String home()
     {       	
		return "login/profile";
     }
	
	 /*device adding form */ 
	 
	 @RequestMapping(value="/deviceaddingform", method=RequestMethod.GET)	  
	 public String deviceAddingForm( Model model)
	 {       		 
		 return "admin/deviceadding";
	 }	
	 
	 @RequestMapping(value="/deviceadding",method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute DevicesAdmin devicesadd,HttpServletRequest request,HttpServletResponse response,Model model ) throws Exception 
	  {
        deviceaddservice.save(devicesadd);
        model.addAttribute("message","succesfully created");
		return new ModelAndView("admin/success");		  
	  }	 
	 	 
	 /*devices list*/
	 
	 @RequestMapping(value="/devices",method=RequestMethod.GET)
	 public String list(Model model)
	 {
		 model.addAttribute("devices",deviceaddservice.list());
		 return "admin/devices";		 
	 }	 
	 
	 /* department adding form */	 
	/* 
	 @RequestMapping(value="/departmentaddingform",method=RequestMethod.GET)
	 public String departmentAddingForm(Model model)
	 {
		return "department/departmentadd";		 
	 }	 
	 
	 @RequestMapping(value="/departmentadd",method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute Department departmentadd,HttpServletRequest request,HttpServletResponse response,Model model ) throws Exception
	 {
		deptaddservice.save(departmentadd);
		model.addAttribute("message","successfully added");
		return new ModelAndView("department/departmentadd");		 
	 }	 */
	 
	 /* department list */
	 
	 @RequestMapping(value="/deplist",method=RequestMethod.GET)
	 public String depList(Model model)
	 {
		 model.addAttribute("deplist", deptaddservice.list());
		 return "department/deplist";
	 }	 
	 
	 /* employee add form */
	 
	 @RequestMapping(value="/employeeaddform",method=RequestMethod.GET)
	 public String employeeAddForm(Model model)
	 {				 
		 Session session=sessionfactory.openSession();
		 String hql="from Department";
		 Query query=session.createQuery(hql);
		 List<Department> dept=query.list();
		 model.addAttribute("dept", dept);
		 return "employee/employeeadd";
	 }	 	
	 
	/* @RequestMapping(value="dept")
	 public String index(Model model,Department department)
	 {
		 model.addAttribute("dept", empaddservice.FindAlldeptlists(department));
		 return null;
	 }*/
	 
	 @RequestMapping(value="/employeeadd",method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute Users empadd,HttpServletRequest request,HttpServletResponse response,Model model ) throws Exception
	 {
		 
		empaddservice.save(empadd);
		model.addAttribute("deptName", empadd);
		return new ModelAndView("employee/empsuccess");
	 }
	 
	 /*employee list*/
	 
	 @RequestMapping(value="/userlist",method=RequestMethod.GET)
	 public String userList(Model model)
	 {
		 model.addAttribute("userlist", empaddservice.list());
		 return "employee/userlist";
	 }
}