package com.qa.emp.parser.repository;

import java.util.List;

import com.qa.emp.parser.bean.Employee;
import com.qa.emp.parser.util.CsvReader;

public class EmployeeRepository {
	
	List<Employee> empList;
	
	public EmployeeRepository() {
		CsvReader csvReader = new CsvReader();
		empList = csvReader.getEmployeesFromCsv();
	}
	
	// Repository methods
	
	public List<Employee> getEmployees(){
		return this.empList;
	}
	
	
	

}
