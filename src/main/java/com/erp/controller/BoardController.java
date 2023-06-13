package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.board.model.BoardVO;
import com.erp.board.service.BoardService;
import com.erp.board.service.BoardServiceImpl;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//한글처리
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);
		
		//게시글 서비스 선언
		BoardService service = new BoardServiceImpl();
		
		//글쓰기 화면에 처리
		if(command.equals("/board/board_write.board")) {
			
			request.getRequestDispatcher("board_write.jsp").forward(request, response);
			
		//목록 화면에 처리
		} else if(command.equals("/board/board_list.board")) {
			
			//목록을 가지고 나옴
			List<BoardVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("board_list.jsp").forward(request, response);

		//등록 작업 (form방식으로 넘어오는 데이터)
		} else if (command.equals("/board/registForm.board")) {
			
			service.regist(request, response);
			//1.forward
			//2.redirect
			response.sendRedirect("board_list.board");
			//request.getRequestDispatcher("board_list.jsp").forward(request, response);
			
		//상세 화면
		} else if(command.equals("/board/board_content.board")) {
			
			BoardVO vo = service.getContent(request, response);
			
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("board_content.jsp").forward(request, response);
			
		//수정 화면
		} else if(command.equals("/board/board_modify.board")) {
			//getContent : post_number
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("board_modify.jsp").forward(request, response);
		//글 수정
		} else if(command.equals("/board/board_update.board")) {
			
			service.update(request, response);
			
			String post_number = request.getParameter("post_number");
			//상세페이지로 이동
			//글 수정화면에서 필요한 bno값을 주소값에 태워서 보낸다.
			//이때 request getParameter 값을 설정하여 bno를 밑에 넣어준다.
			response.sendRedirect("board_content.board?post_number="+ post_number);
			
		//글 삭제
		} //...
	}	
}
