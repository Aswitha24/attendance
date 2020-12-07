package com.cg.attendance.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This Bean contains all the details of an employee
 * 
 * @author  Aswitha
 *
 */
@Entity(name = "employees")
public class Employee {
	// empId is primary key for employees entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @NotEmpty(message="Employee Id is required")
    @Column(unique=true,updatable=false)
    @Size(min=8,max=10,message="Employee Id size must be in between 8 and 10")
	private String empId;
	@NotNull(message = "Employee Name is required")
	private String empName;
	@NotNull(message = "Phone Number is required")
	private String phoneNumber;
	@NotNull(message = "Mail ID is required")
	private String empEmail;
	@NotNull(message = "Employee Location is required")
	private String empLocation;
	@NotEmpty(message="Supervisior Id is required")
	private String supervisiorId;

	// Employee details has one to many relationship with Attendance Detail entity
	// using empId
	@OneToMany(mappedBy = "employee")
	private List<AttendanceDetail> attendance = new ArrayList<>();

	// Default constructor for employee bean
	public Employee() {
		super();
	}

	

	public Employee(String empId, String empName, String phoneNumber, String empEmail, String empLocation, String supervisiorId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.phoneNumber = phoneNumber;
		this.empEmail = empEmail;
		this.empLocation = empLocation;
		this.supervisiorId = supervisiorId;
	}



	// setters and getters for Employee to access outside this class
	
	public String getEmpName() {
		return empName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public List<AttendanceDetail> getAttendance() {
		return attendance;
	}

	public void addtAttendance(AttendanceDetail attendance) {
		this.attendance.add(attendance);
	}



	public String getSupervisiorId() {
		return supervisiorId;
	}



	public void setSupervisiorId(String supervisiorId) {
		this.supervisiorId = supervisiorId;
	}

	

}