package com.cg.attendance.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.EmployeeIDException;
import com.cg.attendance.exception.SupervisiorIDException;
import com.cg.attendance.repositories.EmployeeRepository;

/**
 * This class implement all the Employee Service Interface methods
 * @author Suparna Arya
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	Logger log=Logger.getLogger(getClass());
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee viewEmployeeByEmpId(String empId) {
		Employee emp = empRepo.findByEmpId(empId);
		if (emp == null) {
			throw new EmployeeIDException("No employee with such id " + empId);
		}
		log.info("employee fetched by Id "+empId);
		return emp;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp=null;
		try {
			if (employee.getEmpId().equals(employee.getSupervisiorId())) {
				throw new SupervisiorIDException("Employee can't be its own Supervisior");
			}
					 emp= empRepo.save(employee);
					 log.info("employee with id "+employee.getEmpId()+" created");
						return emp;
		} catch (SupervisiorIDException e) {
			throw new SupervisiorIDException("Employee can't be its own Supervisior");
		} catch (Exception e) {
			throw new EmployeeIDException("Employee id " + employee.getEmpId() + " already available");
		}
	}
	@Override
	public List<Employee> viewEmployeesUnderSupervisior(String supervisiorId) {
		List<Employee> employee = empRepo.findEmployeesUnderSupervisior(supervisiorId);
		if (employee == null) {
			throw new SupervisiorIDException("No employee works under supervisior whose id is " + supervisiorId);
		}
		log.info("fetched  employee under supervisor "+supervisiorId);
		return employee;
	}

	@Override
	public List<AttendanceDetail> viewAttendanceByEmpId(String empId) {
		Employee emp = viewEmployeeByEmpId(empId);
			if (emp == null) {
			throw new EmployeeIDException("No attendance with employee id as " + empId + " exists");
		}
		 
		  
		log.info("fetched attendancedetails of an employee by empId "+empId);
		return emp.getAttendance();
	}
}