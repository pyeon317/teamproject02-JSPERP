package com.erp.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter({"/user/user_application_judgement.user", //서류 승인 페이지
			"/user/user_management.user", //직원관리 페이지
			"/user/user_sal_judge.user", //명세서 승인
			"/user/user_emp_judge.user", //재직 승인
	}) 


public class ApplicationAuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//한글처리
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;

		//작성자를 구함
		//세션에 저장된 작성자
		HttpSession session = req.getSession();
		String employee_id = (String)session.getAttribute("employee_Id");
		String job_id = (String)session.getAttribute("job_Id");


		if(job_id == null || employee_id == null) {
			res.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('허용하지 않는 접근입니다');");
			out.println("history.go(-1);"); //뒤로 되감기
			out.println("</script>");
			return;
		}

		//작성자와 세션이 같지 않은 경우 
		if(!job_id.contains("MAN")) {
			res.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다');");
			out.println("history.go(-1);"); //뒤로 되감기
			out.println("</script>");
			return;	
		}

	chain.doFilter(request, response);

	}
}
