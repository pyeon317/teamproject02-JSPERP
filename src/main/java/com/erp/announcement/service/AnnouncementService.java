package com.erp.announcement.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.announcement.model.AnnouncementVO;

public interface AnnouncementService {

	void regist(HttpServletRequest request, HttpServletResponse response);
	List<AnnouncementVO> getList(HttpServletRequest request, HttpServletResponse response);
	AnnouncementVO getContent(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
	List<AnnouncementVO> search(HttpServletRequest request, HttpServletResponse response);
	
}
