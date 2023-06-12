package com.erp.announcement.model;

import java.sql.Timestamp;

public class announcementVO {
	
	private int announcement_number;
	private String writer;
	private String announcement_title;
	private int hit;
	private String announcement_content;
	private Timestamp regdate;
	
	public announcementVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public announcementVO(int announcement_number, String writer, String announcement_title, int hit,
			String announcement_content, Timestamp regdate) {
		super();
		this.announcement_number = announcement_number;
		this.writer = writer;
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

	public String getEmployee_id() {
		return writer;
	}

	public void setEmployee_id(String writer) {
		this.writer = writer;
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
