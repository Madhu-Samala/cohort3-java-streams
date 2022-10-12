package com.qa.emp.parser.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.qa.emp.parser.bean.Employee;

public class CsvReader {
	
	//Read from empdata.csv file and return a list of employees
	
	private static final String EMP_CSV_FILE_PATH = "C://qa//java-workspace//emp_parser//src//data//empdata.csv";
	
	public List<Employee> getEmployeesFromCsv(){
		
		List<Employee> employeesList = null;
		try(BufferedReader br = new BufferedReader(new FileReader(new File(EMP_CSV_FILE_PATH)))) {
			br.readLine();
			String empData;
			employeesList = new ArrayList<>();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			while ((empData = br.readLine()) != null) {
				String[] empInfo = empData.split(",");
				Employee employee = new Employee();
				employee.setId(Integer.parseInt(empInfo[0]));
				employee.setFirstName(empInfo[1]);
			    employee.setMiddleName(empInfo[2]);
				employee.setLastName(empInfo[3]);
				employee.setGender(empInfo[4].charAt(0));
				employee.setEmail( empInfo[5]);
				employee.setDob( LocalDate.parse(empInfo[6], formatter));
				employee.setDoj( LocalDate.parse(empInfo[7],formatter));
				employee.setSalary(Double.parseDouble(empInfo[8]));
				employee.setPhoneNo( empInfo[9] );
				employee.setCountry(empInfo[10]);
				employee.setUsername(empInfo[11]);
				employee.setPassword( empInfo[12]);
				
				employeesList.add(employee);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return employeesList;
		
	}

}
