package com.qa.emp.parser.main;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.qa.emp.parser.bean.Employee;
import com.qa.emp.parser.service.EmployeeService;

public class Main {
	
	public static void main(String[] args) {
		
		List<Employee> empList;
		
		EmployeeService empService = new EmployeeService();
		empList = empService.getEmpDetails();
		
		System.out.println(empList.size());
		
		
		
		//Streams
		// Intermediate methods
		// Terminal Methods
		//count()
		
		System.out.println("Count : " + empList.stream().count());
		
		
		//ForEach
		/*
		 * empList.stream().forEach((emp) -> { System.out.println(emp); });
		 */
		//filter
		//Collectors
		List<Employee> empListWithSalary = empList.stream().filter(emp -> emp.getSalary() >= 92758 && emp.getGender() == 'M').collect(Collectors.toList());
		
		empListWithSalary.stream().forEach((emp) -> {
			System.out.println(emp);
		});
		
		//map method
		
		//All emails for employees
		// method reference to point to the method
		List<String> empEmailsList = empList.stream().map(Employee::getEmail).collect(Collectors.toList());
		/*
		 * empEmailsList.stream().forEach((email) -> { System.out.println(email); });
		 */
		
		empEmailsList.stream().forEach(System.out::println);
		
		//Sort Employees
		List<Employee> empSortedWithFirstName = empList.stream().sorted(Comparator.comparing(Employee::getLastName)).collect(Collectors.toList());
		empSortedWithFirstName.stream().forEach(System.out::println);
	}

}
