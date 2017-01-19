package com.qts.hardware.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qts.hardware.reception.model.RecpDev;
import com.qts.hardware.reception.service.RecpDevService;

@Controller
public class EmpController
{
	@Autowired
	private RecpDevService recpdevservice;
	

	
	 @RequestMapping(value="/emphome",method=RequestMethod.GET)
	 public String home()
     {       	
		return "home/emphome";
     }
	 
	 /* devices list */	 
	 
	 @RequestMapping(value="/assigneddevices",method=RequestMethod.GET)
	 public String list(Model model)
	 {
		 model.addAttribute("assigneddevices",recpdevservice.list());
		 return "repair/assigneddevices";		 
	 } 	
	 /*Edit list*/

	@RequestMapping(value="/editdeviceForm",method=RequestMethod.GET)
	 public String updateForm(Model model)
	 {
		 return "repair/editdevice";
	 }
	
	@RequestMapping(value="/editdevice",method=RequestMethod.GET)
	 public ModelAndView update(@ModelAttribute RecpDev recpDev,HttpServletRequest request,HttpServletResponse response,Model model ) throws Exception 
	 {		 
		 recpdevservice.update(recpDev);
		 model.addAttribute("editdevice", recpDev);		 
		 return new ModelAndView("repair/editdevice");
	 } 
}
