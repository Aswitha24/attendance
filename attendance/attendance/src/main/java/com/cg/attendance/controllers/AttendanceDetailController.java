package com.cg.attendance.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.attendance.dto.AttendanceDto;
import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.services.AttendanceDetailService;
import com.cg.attendance.services.MapValidationErrorService;

/**
 * This java class handle all the requests of the 
 * @author Suparna
 *
 */
@RestController
public class AttendanceDetailController {
	Logger log=Logger.getLogger(getClass());

	@Autowired
	private AttendanceDetailService attendanceService;

	@Autowired
	private MapValidationErrorService mapValidateErrorService;

	@GetMapping
	@RequestMapping("/attendance/{id}")
	public ResponseEntity<?> viewAttendanceById(@PathVariable String id) throws AttendanceIDException {
		return new ResponseEntity<AttendanceDetail>(attendanceService.viewAttendanceByAttendanceId(id), HttpStatus.OK);
	}
	
	
	@PostMapping("/attendance/add")
	public ResponseEntity<?> addNewAttendance(@Valid @RequestBody AttendanceDto attendance, BindingResult result)
			throws AttendanceIDException {
		ResponseEntity<?> errorMap = mapValidateErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		AttendanceDetail newAttendance = attendanceService.addAttendanceDetail(attendance);
		log.info("added attendance");
		return new ResponseEntity<AttendanceDetail>(newAttendance, HttpStatus.CREATED);

	}

	@PutMapping("/attendance/update/{id}/{updateType}")
	public ResponseEntity<?> updateAttendanceByStatus(@PathVariable String id, @PathVariable String updateType) throws AttendanceIDException {
		log.info("attendance details updated");
		return new ResponseEntity<AttendanceDetail>(attendanceService.updateAttendanceStatus(id, updateType), HttpStatus.OK);

	}

}