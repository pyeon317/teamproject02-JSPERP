package com.erp.user.model;

import java.sql.Timestamp;

public class UserVO {
	
	private String employee_Id;
	private String name;
	private String email;
	private String phone_Number;
	private Timestamp hire_Date;
	private String job_Id;
	private int salary;
	private int commission;
	private int manager_Id;
	private int department_Id;
	private String password;
	
	public UserVO() {
		
	}
	
	public UserVO(String employee_Id, String name, String email, String phone_Number, Timestamp hire_Date, String job_Id,
			int salary, int commission, int manager_Id, int department_Id, String password) {
		super();
		this.employee_Id = employee_Id;
		this.name = name;
		this.email = email;
		this.phone_Number = phone_Number;
		this.hire_Date = hire_Date;
		this.job_Id = job_Id;
		this.salary = salary;
		this.commission = commission;
		this.manager_Id = manager_Id;
		this.department_Id = department_Id;
		this.password = password;
	}

	public String getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public Timestamp getHire_Date() {
		return hire_Date;
	}

	public void setHire_Date(Timestamp hire_Date) {
		this.hire_Date = hire_Date;
	}

	public String getJob_Id() {
		return job_Id;
	}

	public void setJob_Id(String job_Id) {
		this.job_Id = job_Id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getManager_Id() {
		return manager_Id;
	}

	public void setManager_Id(int manager_Id) {
		this.manager_Id = manager_Id;
	}

	public int getDepartment_Id() {
		return department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
