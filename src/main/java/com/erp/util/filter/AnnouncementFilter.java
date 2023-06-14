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

@WebFilter({"/announcement/announcement_modify.announcement",
		   	"/announcement/announcement_update.announcement",
		   	"/announcement/announcement_delete.announcement"})
public class AnnouncementFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		//한글처리
		request.setCharacterEncoding("utf-8");
	
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;

		//작성자를 구함
		String writer = req.getParameter("employee_id");
		//세션에 저장된 작성자 구함
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("employee_Id");
		
		if(writer != null || user_id != null) {
			//작성자와 세션이 같지 않은 경우
			if( !writer.equals(user_id) ) {
				
				//res.sendRedirect(path);
				res.setContentType("text/html; charset=UTF-8;");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("alert('권한이 없습니다')");
				out.println("history.go(-1);");
				out.println("</script>");
				return;
			}
		
			//반드시 필요
			chain.doFilter(request, response);
		
		}
	}
}
