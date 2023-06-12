package com.erp.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = req.getSession();
		
		if( command.equals() ) {
			
			req.getRequestDispatcher("").forward(req, resp);
			
		}else if( command.equals() ) {
			
			req.getRequestDispatcher("").forward(req, resp);
			
		}else if( command.equals() ) {
			
			req.getRequestDispatcher("").forward(req, resp);
			
		}
	}
	
}
