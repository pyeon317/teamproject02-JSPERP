package com.erp.announcement.model;

import java.sql.Timestamp;

public class AnnouncementVO {
	
	private int announcement_number;
	private String EMPLOYEE_ID;
	private String announcement_title;
	private int hit;
	private String announcement_content;
	private Timestamp regdate;
	
	public AnnouncementVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementVO(int announcement_number, String EMPLOYEE_ID, String announcement_title, int hit,
			String announcement_content, Timestamp regdate) {
		super();
		this.announcement_number = announcement_number;
		this.EMPLOYEE_ID = EMPLOYEE_ID;
		this.announcement_title = announcement_title;
		this.hit = hit;
		this.announcement_content = announcement_content;
		this.regdate = regdate;
	}

	public int getAnnouncement_number() {
		return announcement_number;
	}

	public void setAnnouncement_number(int announcement_number) {
		this.announcement_number = announcement_number;
	}

	public String getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}

	public void setEMPLOYEE_ID(String EMPLOYEE_ID) {
		this.EMPLOYEE_ID = EMPLOYEE_ID;
	}

	public String getAnnouncement_title() {
		return announcement_title;
	}

	public void setAnnouncement_title(String announcement_title) {
		this.announcement_title = announcement_title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getAnnouncement_content() {
		return announcement_content;
	}

	public void setAnnouncement_content(String announcement_content) {
		this.announcement_content = announcement_content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	} 
	
	
}
