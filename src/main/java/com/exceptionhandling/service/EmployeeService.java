package com.exceptionhandling.service;

import java.util.List;
import java.util.Optional;

import com.exceptionhandling.error.EmployeeNotFoundException;
import com.exceptionhandling.model.Employee;

public interface EmployeeService {

	Employee saveEmployeeData(Employee employee);

	List<Employee> fetchEmployeeList();

	Employee fetchEmployeeById(Long empId) throws EmployeeNotFoundException;

	void deleteEmployeeById(Long empId);

	Employee updateEmployeeById(Long empId, Employee employee);

	List<Employee> fetchEmployeeByName(String empName);

	List<Employee> fetchEmployeeByNameAndSal(String empName, double sal);
	
	
 
}
