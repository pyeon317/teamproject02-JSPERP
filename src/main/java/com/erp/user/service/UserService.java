package com.erp.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.announcement.model.AnnouncementVO;
import com.erp.document.model.DocumentVO;
import com.erp.user.model.UserVO;

public interface UserService {
	
		//추상메서드
		int join(HttpServletRequest request, HttpServletResponse response);
		
		UserVO login(HttpServletRequest request, HttpServletResponse response);
		
		UserVO getInfo(HttpServletRequest request, HttpServletResponse response);
		
		int updateInfo(HttpServletRequest request, HttpServletResponse response);
		
		int applySalary(HttpServletRequest request, HttpServletResponse response);
		
		int applyEmployment(HttpServletRequest request, HttpServletResponse response);
		
		String applySalaryResult(HttpServletRequest request, HttpServletResponse response);
		
		String applyEmploymentResult(HttpServletRequest request, HttpServletResponse response);
		
		int withdraw(HttpServletRequest request, HttpServletResponse response);

		int application_emp_judgement(HttpServletRequest request, HttpServletResponse response);
		
		int application_sal_judgement(HttpServletRequest request, HttpServletResponse response);
		
		List<UserVO> getList(HttpServletRequest request, HttpServletResponse response);
		
		int retire(HttpServletRequest request, HttpServletResponse response);
		
		void delete (HttpServletRequest request, HttpServletResponse response);
		
		List<UserVO> getRetirementList (HttpServletRequest request, HttpServletResponse response);
		
		List<DocumentVO> getDocumentList (HttpServletRequest request, HttpServletResponse response);
		
		List<DocumentVO> getsalDocumentList (HttpServletRequest request, HttpServletResponse response);
}
