package com.exceptionhandling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private long empId;

	@Column(name = "employee_name")
	private String empName;

	@Column(name = "employee_designation")
	private String empDesg;

	@Column(name = "employee_salary")
	private double empSal;

	@Column(name = "employee_location")
	private String empLoc;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getEmpLoc() {
		return empLoc;
	}

	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}

	public Employee(long empId, String empName, String empDesg, double empSal, String empLoc) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesg = empDesg;
		this.empSal = empSal;
		this.empLoc = empLoc;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesg=" + empDesg + ", empSal=" + empSal
				+ ", empLoc=" + empLoc + "]";
	}

}
