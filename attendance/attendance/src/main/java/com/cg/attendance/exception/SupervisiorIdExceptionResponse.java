package com.cg.attendance.exception;

public class SupervisiorIdExceptionResponse {

	private String supervisiorId;

	public SupervisiorIdExceptionResponse(String supervisiorId) {
		super();
		this.supervisiorId = supervisiorId;
	}

	public String getSupervisiorId() {
		return supervisiorId;
	}

	public void setSupervisiorId(String supervisiorId) {
		this.supervisiorId = supervisiorId;
	}


}