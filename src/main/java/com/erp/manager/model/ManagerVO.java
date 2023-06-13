package com.erp.manager.model;

public class ManagerVO {

	private String document_number;
	private String employee_Id;
	private String document_status;
	
	public ManagerVO() {
		
	}

	public ManagerVO(String document_number, String employee_Id, String document_status) {
		super();
		this.document_number = document_number;
		this.employee_Id = employee_Id;
		this.document_status = document_status;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public String getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getDocument_status() {
		return document_status;
	}

	public void setDocument_status(String document_status) {
		this.document_status = document_status;
	}
	
	
	
}
