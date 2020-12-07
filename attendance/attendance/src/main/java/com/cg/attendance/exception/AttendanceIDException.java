package com.cg.attendance.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
/**
 *  This is Attendance Id custom exception
 * @author Suparna Arya
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttendanceIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer attendanceId;
	public AttendanceIDException() {
		super();
	}

	public AttendanceIDException(String errMsg) {
		super(errMsg);
		
	}
}