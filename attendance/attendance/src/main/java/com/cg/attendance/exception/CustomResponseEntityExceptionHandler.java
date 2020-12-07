package com.cg.attendance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler{
	@ExceptionHandler
	public final ResponseEntity<Object> handleEmployeeIdException(EmployeeIDException ex, WebRequest request)
	{
		EmployeeIdExceptionResponse exceptionResponse=new EmployeeIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
				
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleSupervisiorIdException(SupervisiorIDException ex, WebRequest request)
	{
		SupervisiorIdExceptionResponse exceptionResponse=new SupervisiorIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
				
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleAttendanceIdException(AttendanceIDException ex, WebRequest request)
	{
		AttendanceIdExceptionResponse exceptionResponse=new AttendanceIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
				
	}

}
