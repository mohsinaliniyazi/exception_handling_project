package com.exceptionhandling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exceptionhandling.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	Employee findByEmpName(String empName);
	
	@Query("select e FROM Employee e")
	public List<Employee> getAllEmployee();
	
	@Query("FROM Employee where empName = ?1")
	public List<Employee> getAllEmployeeByName(String empName);

	@Query("FROM Employee where empName = ?1 AND empSal = ?2")
	public List<Employee> getAllEmployeeByNameAndSal(String empName, double empSal);

}
