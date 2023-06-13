package com.erp.manager.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.manager.model.ManagerDAO;
import com.erp.manager.model.ManagerVO;


public class ManagerServiceImpl implements ManagerService {

	@Override
	public List<ManagerVO> application_employment_judgement_page(HttpServletRequest request, HttpServletResponse response) {
		
		ManagerDAO dao = ManagerDAO.getInstance();

		List<ManagerVO> list = dao.application_employment_judgement_page();
		
		return list;
	}

	@Override
	public List<ManagerVO> application_salary_judgement_page(HttpServletRequest request, HttpServletResponse response) {
		ManagerDAO dao = ManagerDAO.getInstance();

		List<ManagerVO> list = dao.application_salary_judgement_page();
		
		return list;
	}

}
