package com.erp.board.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.announcement.model.AnnouncementDAO;
import com.erp.board.model.BoardDAO;
import com.erp.board.model.BoardVO;

public class BoardServiceImpl implements BoardService{

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		//title, employee id, content
		HttpSession session = request.getSession();
		String employee_id = (String)session.getAttribute("employee_Id");
		String public_private = request.getParameter("public_private");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(employee_id, public_private, post_title, post_content, reg_date);
	}
	
	@Override
	public List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.getList();

		return list;
	}

	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {

		String post_number = request.getParameter("post_number");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(post_number);
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

		String post_number = request.getParameter("post_number");
		String public_private = request.getParameter("public_private");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(post_number, public_private, post_title, post_content, reg_date);
		
	}

	@Override
	public List<BoardVO> search(String searchKeyword) {
	    List<BoardVO> searchResults = new ArrayList<>();
	    return searchResults;
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String post_number = request.getParameter("post_number");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(post_number);
		
	}
}
