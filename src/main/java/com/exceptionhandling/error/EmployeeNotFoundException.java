package com.exceptionhandling.error;


public class EmployeeNotFoundException extends Exception{

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	public EmployeeNotFoundException() {
		super();
	}
	
}
