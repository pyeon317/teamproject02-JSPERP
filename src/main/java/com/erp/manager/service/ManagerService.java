package com.erp.manager.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.manager.model.ManagerVO;

public interface ManagerService {

	List<ManagerVO> application_employment_judgement_page(HttpServletRequest request, HttpServletResponse response);
	
	List<ManagerVO> application_salary_judgement_page(HttpServletRequest request, HttpServletResponse response);
}
