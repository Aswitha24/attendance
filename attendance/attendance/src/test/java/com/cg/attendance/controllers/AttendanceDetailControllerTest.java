package com.cg.attendance.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.services.AttendanceDetailService;

@SpringBootTest
class AttendanceDetailControllerTest {

	@InjectMocks
	AttendanceDetailController attenDanceController;

	@Mock
	AttendanceDetailService service;

	@Test
	public void viewAttendanceByIdTest() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157");

		AttendanceDetail attendance1 = new AttendanceDetail("10:10", "14:30", null, "", "", "APPLIED", employee);

		when(service.viewAttendanceByAttendanceId(any(String.class))).thenReturn(attendance1);

		ResponseEntity<?> responseEntity = attenDanceController.viewAttendanceById("1");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	public void updateAttendanceStatusTest() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157");

		AttendanceDetail attendance1 = new AttendanceDetail("10:10", "14:30", null, "", "", "APPLIED", employee);

		when(service.updateAttendanceStatus("1", "APPROVED")).thenReturn(attendance1);

		ResponseEntity<?> responseEntity = attenDanceController.viewAttendanceById("1");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

}