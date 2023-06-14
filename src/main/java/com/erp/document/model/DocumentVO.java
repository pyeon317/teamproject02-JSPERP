package com.erp.document.model;

public class DocumentVO {

	private String document_number;
	private String employee_id;
	private String confirm;
	
	public DocumentVO() {
		
	}
	
	public DocumentVO(String document_number, String employee_id, String confirm) {
		super();
		this.document_number = document_number;
		this.employee_id = employee_id;
		this.confirm = confirm;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	
	
}
