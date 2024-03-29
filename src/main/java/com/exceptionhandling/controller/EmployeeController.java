package com.exceptionhandling.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionhandling.error.EmployeeNotFoundException;
import com.exceptionhandling.model.Employee;
import com.exceptionhandling.response.APIResponse;
import com.exceptionhandling.service.EmployeeService;

@RestController
public class EmployeeController {

	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee saveEmployeeData(@RequestBody Employee employee) {
		LOGGER.info("saveEmployeeData is method within EmployeeController {}");
		return empService.saveEmployeeData(employee);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> fetchEmployeeList(){
		LOGGER.info("fetchEmployeeList is method within EmployeeController {}");
		return empService.fetchEmployeeList();
	}
	
	@RequestMapping(value = "/employee1", method = RequestMethod.GET)
	public List<Employee> fetchEmployeeList1(){
		LOGGER.info("fetchEmployeeList is method within EmployeeController {}");
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = new Employee(1, "Mohsin", "Sof Engineer", 101.0, "Pune");
		Employee emp1 = new Employee(1, "Sana", "Sof Engineer", 102.0, "Chandigarh");
		list.add(emp);
		list.add(emp1);
		return list;
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee fetchEmployeeById(@PathVariable("id") Long empId) throws EmployeeNotFoundException {
		LOGGER.info("fetchEmployeeById is method within EmployeeController {}");
		return empService.fetchEmployeeById(empId);
	}
	
	@RequestMapping(value = "employee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployeeById(@PathVariable("id") Long empId) {
		empService.deleteEmployeeById(empId);
		LOGGER.info("deleteEmployeeById is method within EmployeeController {}");
		return "Employee deleted successfully";
	}
	
	@RequestMapping(value = "employee/{id}", method = RequestMethod.PUT)
	public Employee updateEmployeeById(@PathVariable("id") Long empId, @RequestBody Employee employee) {
		LOGGER.info("updateEmployeeById is method within EmployeeController {}");
		return empService.updateEmployeeById(empId, employee);
	}
	
	@RequestMapping(value = "employee/name/{name}", method = RequestMethod.GET)
	public APIResponse<List<Employee>> fetchEmployeeByName(@PathVariable("name") String empName) {
		LOGGER.info("fetchEmployeeByName is method within EmployeeController {}");
		List<Employee> list = empService.fetchEmployeeByName(empName);
		
		if(list.size()==0) {
			return  new APIResponse<>(list.size(),HttpStatus.NOT_FOUND,list);
		}
		return  new APIResponse<>(list.size(),HttpStatus.OK,list);
	}
	
	@RequestMapping(value = "employee/name/{name}/{sal}", method = RequestMethod.GET)
	public List<Employee> fetchEmployeeByName(@PathVariable("name") String empName, @PathVariable("sal") double sal) {
		LOGGER.info("fetchEmployeeByNameAndSal is method within EmployeeController {}");
		return empService.fetchEmployeeByNameAndSal(empName,sal);
	}
	
}
