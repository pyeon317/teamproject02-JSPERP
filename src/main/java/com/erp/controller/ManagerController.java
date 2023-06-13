package com.erp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.manager.model.ManagerVO;
import com.erp.manager.service.ManagerService;
import com.erp.manager.service.ManagerServiceImpl;




@WebServlet("*")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");

		//경로
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);

		ManagerService service = new ManagerServiceImpl();
		HttpSession session = request.getSession();
		
		if(command.equals("/manager/manager_application_judgement_page.user")) {
			//관리자가 서류검토 눌렀을 때 검토페이지로 이동
			List<ManagerVO> list1 = new ArrayList<>();
			List<ManagerVO> list2 = new ArrayList<>();
			
			list1 = service.application_employment_judgement_page(request, response);
			list2 = service.application_salary_judgement_page(request, response);
			
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			
			request.getRequestDispatcher("manager_application_judgement.jsp").forward(request, response);;
		} else if(command.equals("/manager/manager_application_judgement.user")) {
			//관리자가 서류허가 눌렀을 때 허가하기
			
		}
	}
}
