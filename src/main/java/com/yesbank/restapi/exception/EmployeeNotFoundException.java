package com.yesbank.restapi.exception;

public class EmployeeNotFoundException  extends IllegalArgumentException{
	
private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(String id) {
		super(String.format("Employee with Id %s not found",id));
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundException [toString()=" + super.toString() + "]";
	}

}
