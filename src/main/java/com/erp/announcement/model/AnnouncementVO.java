package com.erp.announcement.model;

import java.sql.Timestamp;

public class AnnouncementVO {
	
	private String announcement_number;
	private String employee_id;
	private String announcement_title;
	private int hit;
	private String announcement_content;
	private Timestamp regdate;
	
	public AnnouncementVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementVO(String announcement_number2, String employee_id, String announcement_title, int hit,
			String announcement_content, Timestamp regdate) {
		super();
		this.announcement_number = announcement_number2;
		this.employee_id = employee_id;
		this.announcement_title = announcement_title;
		this.hit = hit;
		this.announcement_content = announcement_content;
		this.regdate = regdate;
	}

	public String getannouncement_number() {
		return announcement_number;
	}

	public void setannouncement_number(String announcement_number) {
		this.announcement_number = announcement_number;
	}

	public String getemployee_id() {
		return employee_id;
	}

	public void setemployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getannouncement_title() {
		return announcement_title;
	}

	public void setannouncement_title(String announcement_title) {
		this.announcement_title = announcement_title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getannouncement_content() {
		return announcement_content;
	}

	public void setannouncement_content(String announcement_content) {
		this.announcement_content = announcement_content;
	}

	public Timestamp getregdate() {
		return regdate;
	}

	public void setregdate(Timestamp regdate) {
		this.regdate = regdate;
	} 
	
	
}
