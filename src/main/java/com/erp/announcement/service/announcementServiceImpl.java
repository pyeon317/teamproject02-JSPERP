package com.erp.announcement.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.announcement.model.announcementVO;
import com.erp.announcement.model.announcementDAO;

public class announcementServiceImpl implements announcementService{

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		//title, writer, content
		String writer = request.getParameter("writer");
		String title = request.getParameter("announcement_title");
		String content = request.getParameter("announcement_content");
		
		announcementDAO dao = announcementDAO.getInstance();
		dao.regist(writer, title, content);
	}

	@Override
	public List<announcementVO> getList(HttpServletRequest request, HttpServletResponse response) {
		announcementDAO dao = announcementDAO.getInstance();
		List<announcementVO> list = dao.getList();
		return list;
	}

	@Override
	public announcementVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String announcement_number = request.getParameter("announcement_number");
		
		announcementDAO dao = announcementDAO.getInstance();
		announcementVO vo = dao.getContent(announcement_number);
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		String announcement_number = request.getParameter("announcement_number");
		String writer = request.getParameter("writer");
		String title =  request.getParameter("announcement_title");
		String content = request.getParameter("announcement_content");
		
		announcementDAO dao = announcementDAO.getInstance();
		dao.update(announcement_number, title, content);
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
