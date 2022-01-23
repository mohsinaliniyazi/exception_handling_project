package com.exceptionhandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exceptionhandling.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	Employee findByEmpName(String empName);

}
