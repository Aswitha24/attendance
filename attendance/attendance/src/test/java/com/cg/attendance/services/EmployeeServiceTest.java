package com.cg.attendance.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.EmployeeIDException;
import com.cg.attendance.repositories.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {
		
	@MockBean
    private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	void addEmployeeTest() throws EmployeeIDException{
		
		Employee employee = new Employee("46456786","lakshmi","5432127711","aswi123@gmail.com","Banglore","45046123");
		when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);
	   	 Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	   	 assertThat(employeeService.addEmployee(employee)).isEqualTo(employee);               
	}
	
	@Test
	void getEmployeeDetailByIdTest() throws Exception{
		
		Employee employee = new Employee("46045346","chakri","0985763267","chakri123@gmail.com","Banglore","45046123");

		when(employeeService.viewEmployeeByEmpId(any(String.class))).thenReturn(employee);
        Mockito.when(employeeRepository.findByEmpId("46045346")).thenReturn(employee);
       assertThat(employeeService.viewEmployeeByEmpId("46045346")).isEqualTo(employee);        
		
}

	@Test
	public void EmployeeUnderSupervisiorTest() {
		Employee employee1 = new Employee("46045146","Aswitha","7032127711","aswi123@gmail.com","Banglore","45046123");
		Employee employee2 = new Employee("46045234","hema","8179460375","hema123@gmail.com","Banglore","45046123");
		List<Employee> Employees = new ArrayList<>();
		Employees.add(employee1);
		Employees.add(employee2);
        Mockito.when(employeeRepository.findAll()).thenReturn(Employees);
        assertThat(employeeService.viewEmployeesUnderSupervisior("45046123")).isEqualTo(Employees);
        
	}
}

