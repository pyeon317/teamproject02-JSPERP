package com.erp.user.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.document.model.DocumentVO;
import com.erp.user.model.UserDAO;
import com.erp.user.model.UserVO;

public class UserServiceImpl implements UserService {

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		String employee_Id = request.getParameter("employee_Id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone_Number = request.getParameter("phone_Number");
		String job_Id = request.getParameter("job_Id");
		int department_Id  = Integer.parseInt(request.getParameter("department_Id"));
		String password = request.getParameter("password");
		
		//싱글톤 객체를 얻는 방법
		UserDAO dao = UserDAO.getInstance();
		
		//아이디 중복검사
		int result = dao.idCheck(employee_Id);

		//회원 가입 완료
		if(result == 1) { //중복시 가입처리 x
			return 1;
		} else { //중복 아닐 시 가입처리 o
			UserVO vo = new UserVO(employee_Id, name, email, phone_Number, null, job_Id, 0, 0, 0, department_Id, password);
			dao.join(vo);
			return 0;
		}
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		String employee_Id = request.getParameter("employee_Id");
		String password = request.getParameter("password");
		
		UserDAO dao = UserDAO.getInstance();

		UserVO vo = dao.login(employee_Id, password);
		
		return vo;
	}

	@Override
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String employee_Id = (String)session.getAttribute("employee_Id");
		

		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(employee_Id);
		return vo;
	}

	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		String employee_Id = request.getParameter("employee_Id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone_Number = request.getParameter("phone_Number");
		String job_Id = request.getParameter("job_Id");
		String password = request.getParameter("password");

		UserVO vo = new UserVO(employee_Id, name, email, phone_Number, null, job_Id, 0, 0, 0, 0, password);

		UserDAO dao = UserDAO.getInstance();		
		int result = dao.updateInfo(vo);	
		
		return result;
		
	}
	
	@Override
	public int applySalary(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String employee_Id = (String)session.getAttribute("employee_Id");
		UserDAO dao = UserDAO.getInstance();		
		int result = dao.applySalary(employee_Id);	
		return result;
	}

	@Override
	public int applyEmployment(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String employee_Id = (String)session.getAttribute("employee_Id");
		UserDAO dao = UserDAO.getInstance();		
		int result = dao.applyEmployment(employee_Id);	
		return result;
	}

	@Override
	public String applySalaryResult(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = UserDAO.getInstance();
		HttpSession session = request.getSession();
		String employee_Id = (String)session.getAttribute("employee_Id");
		String result = dao.applySalaryResult(employee_Id);
		return result;
	}
	
	@Override
	public String applyEmploymentResult(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = UserDAO.getInstance();
		HttpSession session = request.getSession();
		String employee_Id = (String)session.getAttribute("employee_Id");
		String result = dao.applyEmploymentResult(employee_Id);
		return result;
	}
	
	@Override
	public int withdraw(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = UserDAO.getInstance();
		HttpSession session = request.getSession();
		String employee_Id = (String)session.getAttribute("employee_Id");
		
		System.out.println(employee_Id);
		int result = dao.withdraw(employee_Id);
		return result;
	}

	@Override

	public int application_emp_judgement(HttpServletRequest request, HttpServletResponse response) {
		String permit_Id = request.getParameter("permit_Id");
		UserDAO dao = UserDAO.getInstance();
		int result = dao.application_emp_judgement(permit_Id);
		
		return result;
	}

	public int application_sal_judgement(HttpServletRequest request, HttpServletResponse response) {
		String permit_Id = request.getParameter("permit_Id");
		UserDAO dao = UserDAO.getInstance();
		int result = dao.application_sal_judgement(permit_Id);
		
		return result;
	}

	@Override
	public List<UserVO> getList(HttpServletRequest request, HttpServletResponse response) {
	      UserDAO dao = UserDAO.getInstance();
	      List<UserVO> list = dao.getList();
	      return list;
	}

	@Override
	public int retire(HttpServletRequest request, HttpServletResponse response) {
		
		String[] str = request.getParameterValues("retirement");
		UserDAO dao = UserDAO.getInstance();
		int result = dao.retire(str);
		return result;
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String[] str = request.getParameterValues("retirement");
		UserDAO dao = UserDAO.getInstance();
		dao.delete(str);
	}

	@Override
	public List<UserVO> getRetirementList(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = UserDAO.getInstance();
	    List<UserVO> list = dao.getRetirementList();
	    return list;
	}

	@Override
	public List<DocumentVO> getDocumentList(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = UserDAO.getInstance();
	    List<DocumentVO> list = dao.getDocumentList();
	    return list;
	}
	
	public List<DocumentVO> getsalDocumentList(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = UserDAO.getInstance();
	    List<DocumentVO> list = dao.getsalDocumentList();
	    return list;
	}
	
}
