package com.erp.board.model;

import java.sql.Timestamp;

public class BoardVO {
	private String post_number;
	private String employee_id;
	private String post_type;
	private String public_private;
	private String post_title;
	private int hit;
	private String post_content;
	private Timestamp regdate;

	//생성자 2개
	
	public BoardVO() {
		
	}

	public BoardVO(String post_number, String employee_id, String post_type, String public_private, String post_title,
			int hit, String post_content, Timestamp regdate) {
		super();
		this.post_number = post_number;
		this.employee_id = employee_id;
		this.post_type = post_type;
		this.public_private = public_private;
		this.post_title = post_title;
		this.hit = hit;
		this.post_content = post_content;
		this.regdate = regdate;
	}

	//getter / setter
	
	public String getPost_number() {
		return post_number;
	}

	public void setPost_number(String post_number) {
		this.post_number = post_number;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getPublic_private() {
		return public_private;
	}

	public void setPublic_private(String public_private) {
		this.public_private = public_private;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
