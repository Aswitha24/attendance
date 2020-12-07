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


import com.cg.attendance.entities.Employee;
import com.cg.attendance.services.EmployeeService;

/*
 * @Author:Aswitha
 */
@SpringBootTest
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	@Mock
	EmployeeService employeeService;
	
	
	@Test
	void addNewEmployeeTest() throws Exception{
		
		Employee employee = new Employee("46045146","Aswitha","7032127711","aswi123@gmail.com","Banglore","45046123");
		when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);
		
	}


	@Test
	void getEmployeeDetailByIdTest() throws Exception{
		
		Employee employee = new Employee("46045146","Aswitha","7032127711","aswi123@gmail.com","Banglore","45046123");

		when(employeeService.viewEmployeeByEmpId(any(String.class))).thenReturn(employee);

		ResponseEntity<?> responseEntity = employeeController.getEmployeeByEmpId("46045146");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
}
	
	@Test
	void getEmployeeUnderSupervisiorTest() throws Exception{
		
		Employee employee1 = new Employee("46045146","Aswitha","7032127711","aswi123@gmail.com","Banglore","45046123");
		Employee employee2 = new Employee("46045234","hema","8179460375","hema123@gmail.com","Banglore","45046123");
		List<Employee> Employees = new ArrayList<>();
		Employees.add(employee1);
		Employees.add(employee2);
		when(employeeService.viewEmployeesUnderSupervisior(any(String.class))).thenReturn(Employees);

		ResponseEntity<?> responseEntity = employeeController.getEmployeeUnderSupervisior("45046123");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
}	
	
}
	
