package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.user.service.UserService;
import com.erp.user.service.UserServiceImpl;
import com.erp.user.model.UserVO;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserController() {
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

		UserService service = new UserServiceImpl();
		HttpSession session = request.getSession();

		if(command.equals("/user/user_join.user")) {
			//join눌렀을 때 회원가입페이지로 이동
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		} else if(command.equals("/user/joinForm.user")) {
			//회원가입페이지에서 회원가입 요청 눌렀을 때
			int result = service.join(request, response);
			if(result == 1) { //가입실패
				request.setAttribute("msg", "중복된 아이디 입니다."); //1회성 메시지
				request.getRequestDispatcher("user_join.jsp").forward(request, response); //forward를 쓴 이유는 위의 메시지 데이터를 갖고 가기 위함.
			} else { //가입성공
				response.sendRedirect("user_login.user"); //리다이렉트는 다시 컨트롤러를 태워 나가는 용도로 사용한다.
			}
		} else if(command.equals("/user/user_login.user")) {
			//login눌렀을 때 로그인페이지로 이동
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		} else if(command.equals("/user/loginForm.user")) {
			//로그인페이지에서 로그인 요청 눌렀을 때
			UserVO vo = service.login(request, response);
			if(vo == null) { //로그인 실패
				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			} else { //로그인 성공
				session.setAttribute("employee_Id", vo.getEmployee_Id());
				session.setAttribute("name", vo.getName());
				session.setAttribute("job_Id", vo.getJob_Id());
				response.sendRedirect("user_mypage.user");
			}
		} else if(command.equals("/user/user_mypage.user")) {
			//로그인 했을 때, 마이페이지 눌렀을 때 마이페이지로 이동
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
		} else if(command.equals("/user/user_modify.user")) {
			//마이페이지에서 회원정보수정눌렀을 때 회원정보수정페이지로 이동
			UserVO vo = service.getInfo(request, response);
			session.setAttribute("vo", vo);
			request.getRequestDispatcher("user_modify.jsp").forward(request, response);
		} else if(command.equals("/user/user_update.user")) {
			//회원정보수정페이지에서 회원정보수정 요청 눌렀을 때
			int result = service.updateInfo(request, response);
			if(result == 1) { //회원정보 수정성공
				session.setAttribute("name", request.getParameter("name"));
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보가 성공적으로 수정되었습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");

			} else { //회원정보 수정실패
				response.sendRedirect("user_modify.user");
			}
		} else if(command.equals("/user/user_logout.user")) {
			//로그아웃 눌렀을 때 세션해제 하고 로그인 창으로
			session.invalidate();
			response.sendRedirect("user_login.user");
		} else if(command.equals("/user/user_application.user")) {
			//마이페이지에서 서류신청눌렀을 때 서류신청페이지로 이동 
			UserVO vo = service.getInfo(request, response);
			session.setAttribute("vo", vo);
			request.getRequestDispatcher("user_application.jsp").forward(request, response);
		} else if(command.equals("/user/user_salary_document_apply.user")) {
			//서류신청페이지에서 급여명세서 요청 눌렀을 때
			int result = service.applySalary(request, response);
			if(result == 1) { //급여명세서 요청 성공
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('급여명세서 발급을 관리자에게 요청하였습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			} else { //급여명세서 요청 실패
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('급여명세서 발급을 실패하였습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			}
		} else if(command.equals("/user/user_employment_document_apply.user")) {
			//서류신청페이지에서 재직증명서 요청 눌렀을 때
			int result = service.applyEmployment(request, response);
			if(result == 1) { //재직증명서 요청 성공
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('재직증명서 발급을 관리자에게 요청하였습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			} else { //재직증명서 요청 실패
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('재직증명서 발급을 실패하였습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			}
		} else if (command.equals("/user/user_application_salary_judgement.user")){
			//마이페이지에서 급여명세서 서류결과 눌렀을 때 허가판단
			String result = service.applySalaryResult(request, response);
			System.out.println(result);
			if(result.equals("N")) { //허가x
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('관리자가 급여명세서 발급 허가를 하지 않았습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			} else if(result.equals("Y")) { //허가o
				session.setAttribute("judgement", "salaryY");
				request.getRequestDispatcher("user_application_view.user").forward(request, response);
			} else { //신청x
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('급여명세서 발급 신청을 하세요.');");
				out.println("location.href='user_application.user';");				
				out.println("</script>");
			}
		} else if (command.equals("/user/user_application_employment_judgement.user")){
			//마이페이지에서 재직증명서 서류결과 눌렀을 때 허가판단
			String result = service.applyEmploymentResult(request, response);
			if(result.equals("N")) { //허가x
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('관리자가 재직증명서 발급 허가를 하지 않았습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			} else if(result.equals("Y")) { //허가o
				session.setAttribute("judgement", "employmentY");
				request.getRequestDispatcher("user_application_view.user").forward(request, response);
			} else { //신청x
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('재직증명서 발급 신청을 하세요.');");
				out.println("location.href='user_application.user';");				
				out.println("</script>");
			}
		} else if(command.equals("/user/user_application_view.user")) {
			//급여명세서, 재직증명서 서류 허가 결정되었을 때 vo얻어와서 view 페이지로 이동
			UserVO vo = service.getInfo(request, response);
			session.setAttribute("vo", vo);
			request.getRequestDispatcher("user_application_view.jsp").forward(request, response);
		} else if(command.equals("/user/user_withdraw.user")) {
			//회원 탈퇴 눌렀을 때 회원 탈퇴
			int result = service.withdraw(request, response);
			if(result == 1) { //회원탈퇴 성공
				session.invalidate();
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('탈퇴하였습니다.');");
				out.println("location.href='user_login.user';");				
				out.println("</script>");
			} else { //회원탈퇴 실패
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('알 수 없는 오류');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			}
		} else if(command.equals("/user/user_application_judgement.user")) {
			//서류승인 신청 페이지 눌렀을 때
			String id = request.getParameter("employee_Id");
			if(id.equals("sss")) { //서류승인 페이지 진입
				response.sendRedirect("user_manager.jsp");
			} else { //서류승인 페이지 진입불가
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('권한이 없습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			}
			
		} else if(command.equals("/user/user_emp_judge.user")) {
			int result = service.application_emp_judgement(request, response);
			if(result >= 1) { //서류승인 성공  
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('승인하였습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			} else { //서류승인 없음
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('승인할 서류가 없습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			}
		
		} else if(command.equals("/user/user_sal_judge.user")) {
			int result = service.application_sal_judgement(request, response);
			if(result >= 1) { //서류승인 성공  
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('승인하였습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			} else { //서류승인 없음
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('승인할 서류가 없습니다.');");
				out.println("location.href='user_mypage.user';");				
				out.println("</script>");
			}
		
		} else if(command.equals("/user/user_management.user")) {
			//직원명단
			//목록 가져오기
			List<UserVO> list = service.getList(request, response);
			request.setAttribute("list", list);
            request.getRequestDispatcher("user_management.jsp").forward(request, response);
		} else if( command.equals("/user/user_act_retire.user") ) {
			//명단에서 퇴사버튼
			request.getRequestDispatcher("user_management.user").forward(request, response);;
		}
	}	
}
