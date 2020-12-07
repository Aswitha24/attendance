package com.cg.attendance.services;

import java.util.List;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;

/**
 * This interface is a structure for EmployeeService
 * @author Suparna Arya
 *
 */
public interface IEmployeeService {
	 /**
    * This method is used to view Employee using empId
    * @param employee
    */
	public Employee viewEmployeeByEmpId(String empId);
	/**
	 * This method add employee
	 * @param employee
	 * @return 
	 */
	public Employee addEmployee(Employee employee);
	
	/**
	 * This method is used to view Employees working under a supervisor using supervisor id
	 * @param supervisiorId
	 * @return List of Employees
	 */
	public List<Employee> viewEmployeesUnderSupervisior(String supervisiorId);
	
	/**
	 * This method is used to view AttendanceDetails using employeeId
	 * @param empId
	 * @return List of AttendanceDetails
	 */
	public List<AttendanceDetail> viewAttendanceByEmpId(String empId);
}