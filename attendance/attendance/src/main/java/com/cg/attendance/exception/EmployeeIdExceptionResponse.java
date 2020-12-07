package com.cg.attendance.exception;

public class EmployeeIdExceptionResponse {

	private String empId;

	public EmployeeIdExceptionResponse(String empId) {
		super();
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}


}