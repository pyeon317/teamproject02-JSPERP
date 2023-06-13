package com.erp.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.announcement.model.announcementVO;
import com.erp.announcement.service.announcementService;
import com.erp.announcement.service.announcementServiceImpl;

//1. 확장자패턴으로 변경
@WebServlet("*.announcement")
public class announcementController extends HttpServlet {
	private static final long serialVersionUID = 2405130483308819421L;

	public announcementController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}
	
	//2.get/post 하나로 모은다
	protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//3. 요청분기
		
		//한글처리
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String conpath = req.getContextPath();
		String command = uri.substring( conpath.length() );
		
		System.out.println(command); //제대로 이동하는지 확인용
		
		announcementService service = new announcementServiceImpl();
		
		//목록 화면 이동
		if( command.equals("/announcement/announcement_list.announcement") ) {
			
			//목록 가져오기
			List<announcementVO> list = service.getList(req, resp);
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("announcement_list.jsp").forward(req, resp);
		
			
		//글쓰기 화면 이동
		}else if( command.equals("/announcement/announcement_write.announcement") ) {
			
			req.getRequestDispatcher("announcement_write.jsp").forward(req, resp);
		
			
		//글 등록 버튼
		}else if( command.equals("/announcement/registForm.announcement") ) {
			
			service.regist(req, resp);
			
			resp.sendRedirect("announcement_list.jsp");
		
			
		
		}else if( command.equals("/announcement/announcement_content.announcement")){
			
			req.getRequestDispatcher("announcement_content.jsp").forward(req, resp);
			
			
			
		//수정 화면 이동
		}else if( command.equals("/announcement/announcement_modify.announcement") ) {
			
			//수정하기 위해 기존 내용 가져오기
			announcementVO vo = service.getContent(req, resp);
			req.setAttribute("vo", vo);
			
			req.getRequestDispatcher("announcement_modify.jsp").forward(req, resp);
		
			
			
		//수정파일 업데이트
		}else if( command.equals("/announcement/announcement_update.announcement") ) {
		
		req.getRequestDispatcher("announcement_modify.jsp").forward(req, resp);
		
		
		//삭제
		}else if( command.equals("/announcement/announcement_delete.announcement") ) {
			
			req.getRequestDispatcher("").forward(req, resp);
			
			
			
		}
	}
	
}
