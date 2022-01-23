package com.exceptionhandling.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptionhandling.error.EmployeeNotFoundException;
import com.exceptionhandling.model.Employee;
import com.exceptionhandling.repository.EmployeeRepo;
import com.exceptionhandling.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepo empRepository;
	
	@Override
	public Employee saveEmployeeData(Employee employee) {
		LOGGER.info("saveEmployeeData is method within EmployeeServiceImpl {}");
		return empRepository.save(employee);
	}

	@Override
	public List<Employee> fetchEmployeeList() {
		LOGGER.info("fetchEmployeeList is method within EmployeeServiceImpl {}");
		return empRepository.findAll();
	}

	@Override
	public Employee fetchEmployeeById(Long empId) throws EmployeeNotFoundException {
		
		LOGGER.info("fetchEmployeeById is method within EmployeeServiceImpl {}");
		
		Optional<Employee> employee = empRepository.findById(empId);
		
		if(!employee.isPresent()) {
			LOGGER.error("Employee data not Found !!");
			throw new EmployeeNotFoundException("Employee data Not Found");
		}
		
		return employee.get();
	}

	@Override
	public void deleteEmployeeById(Long empId) {
		LOGGER.info("deleteEmployeeById is method within EmployeeServiceImpl {}");
		empRepository.deleteById(empId);
	}

	@Override
	public Employee updateEmployeeById(Long empId, Employee employee) {
		
		Employee emp = empRepository.findById(empId).get();
		
		if(Objects.nonNull(employee.getEmpName()) && 
				!"".equalsIgnoreCase(employee.getEmpName())) {
			emp.setEmpName(employee.getEmpName());
			LOGGER.info("employee.getEmpName() is "+employee.getEmpName());
		}
		
		if(Objects.nonNull(employee.getEmpDesg()) && 
				!"".equalsIgnoreCase(employee.getEmpDesg())) {
			emp.setEmpDesg(employee.getEmpDesg());
			LOGGER.info("employee.getEmpDesg() is "+employee.getEmpDesg());
		}
		
		if(Objects.nonNull(employee.getEmpLoc()) && 
				!"".equalsIgnoreCase(employee.getEmpLoc())) {
			emp.setEmpLoc(employee.getEmpLoc());
			LOGGER.info("employee.getEmpLoc() is "+employee.getEmpLoc());
		}
		
		if(Objects.nonNull(employee.getEmpSal()) && 
					(employee.getEmpSal() > 0)) {
			emp.setEmpSal(employee.getEmpSal());
			LOGGER.info("employee.getEmpSal() is "+employee.getEmpSal());
		}
		
		LOGGER.info("updateEmployeeById is method within EmployeeServiceImpl {}");
		return empRepository.save(emp);
	}

	@Override
	public Employee fetchEmployeeByName(String empName) {
		return empRepository.findByEmpName(empName);
	}

	

}
