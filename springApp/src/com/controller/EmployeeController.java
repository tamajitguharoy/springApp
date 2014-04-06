package com.controller;

import java.util.List;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Employee;
import com.service.IEmployeeSvc;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	IEmployeeSvc employeeSvc;

	@RequestMapping(value = "/create.htm", method = RequestMethod.GET)
	public String register(@ModelAttribute("emp") Employee employee) {
		return "employee/employeeRegister";
	}

	@RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String registerSubmit(@ModelAttribute("emp") Employee employee) {
		employeeSvc.save(employee);
		return "redirect:/employee/list.htm";
	}
	
	@RequestMapping(value = "/edit/{id}.htm", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id,ModelMap map) {
		Employee employee = employeeSvc.findById(id);
		map.put("emp", employee);
		System.out.println(employee);
		return "employee/employeeEdit";
	}
	
	@RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
	public String editSubmit(@ModelAttribute("emp") Employee employee) {
		employeeSvc.save(employee);
		
		return "redirect:/employee/list.htm";
	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Employee> employees = employeeSvc.findAll();
		map.put("employeelist", employees);
		return "employee/employeeList";
	}
	@RequestMapping(value = "/delete/{id}.htm", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id,ModelMap map) {
		employeeSvc.delete(id);
		return "redirect:/employee/list.htm";
	}
	



}
