package com.erp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.board.model.BoardDAO;
import com.erp.board.model.BoardVO;

public class BoardServiceImpl implements BoardService{

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		//title, employee id, content
		String post_writer = request.getParameter("post_writer");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(post_writer, post_title, post_content);
	}

	@Override
	public List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.getList();

		return list;
	}

	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {

		String post_number = request.getParameter("bno");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(post_number);
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		String post_number = request.getParameter("post_number");
		String post_writer = request.getParameter("post_writer");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(post_number, post_title, post_content);
		
	}

}
