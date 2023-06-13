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

//본인이 작성한 글만, 수정 삭제를 할 수 있음
@WebFilter({"/manager/manager_application_judgement.board", //서류 승인
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
		String job_id = req.getParameter("job_id");
		//세션에 저장된 작성자
		HttpSession session = req.getSession();
		String employee_id = (String)session.getAttribute("employee_Id");


		if(job_id == null || employee_id == null) {

			//res.sendRedirect( path );
			res.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('이용하지 않는 접근입니다');");
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
