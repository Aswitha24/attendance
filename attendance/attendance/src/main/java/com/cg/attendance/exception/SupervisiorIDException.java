package com.cg.attendance.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SupervisiorIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SupervisiorIDException() {
		super();
	}

	public SupervisiorIDException(String errMsg) {
		super(errMsg);
	}
}