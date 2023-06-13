package com.erp.announcement.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.announcement.model.AnnouncementVO;
import com.erp.announcement.model.AnnouncementDAO;

public class AnnouncementServiceImpl implements AnnouncementService{

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		//title, EMPLOYEE_ID, content
		String EMPLOYEE_ID = request.getParameter("EMPLOYEE_ID");
		String title = request.getParameter("announcement_title");
		String content = request.getParameter("announcement_content");
		Timestamp regdate = new Timestamp(System.currentTimeMillis());
		
		AnnouncementDAO dao = AnnouncementDAO.getInstance();
		dao.regist(EMPLOYEE_ID, title, content, regdate);
	}

	@Override
	public List<AnnouncementVO> getList(HttpServletRequest request, HttpServletResponse response) {
		AnnouncementDAO dao = AnnouncementDAO.getInstance();
		List<AnnouncementVO> list = dao.getList();
		return list;
	}

	@Override
	public AnnouncementVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String announcement_number = request.getParameter("announcement_number");
		
		AnnouncementDAO dao = AnnouncementDAO.getInstance();
		AnnouncementVO vo = dao.getContent(announcement_number);
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		String announcement_number = request.getParameter("announcement_number");
		String EMPLOYEE_ID = request.getParameter("EMPLOYEE_ID");
		String title =  request.getParameter("announcement_title");
		String content = request.getParameter("announcement_content");
		
		AnnouncementDAO dao = AnnouncementDAO.getInstance();
		dao.update(announcement_number, title, content);
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
