package com.erp.announcement.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.announcement.model.announcementVO;

public interface announcementService {

	void regist(HttpServletRequest request, HttpServletResponse response);
	List<announcementVO> getList(HttpServletRequest request, HttpServletResponse response);
	announcementVO getContent(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
	
}
