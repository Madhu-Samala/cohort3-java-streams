package com.qa.emp.parser.service;

import java.util.List;

import com.qa.emp.parser.bean.Employee;
import com.qa.emp.parser.repository.EmployeeRepository;

public class EmployeeService {
	
	EmployeeRepository empRepository;
	
	public EmployeeService() {
	this.empRepository = new EmployeeRepository();
	}
	
	//Business methods
	
	//1. Get All employee details
	public List<Employee> getEmpDetails(){
		return this.empRepository.getEmployees();
	}

}
