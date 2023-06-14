package com.erp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.board.model.BoardVO;

public interface BoardService {

	//등록 기능
	void regist(HttpServletRequest request, HttpServletResponse response);
	List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	BoardVO getContent (HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	List<BoardVO> search(String searchKeyword);
}
