package com.erp.manager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.erp.manager.model.ManagerDAO;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();

	private ManagerDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	//3.getter를 통해서 객체를 반환
	public static ManagerDAO getInstance() {

		return instance;
	}

	//데이터베이스 연결주소
	private String url = "jdbc:oracle:thin:@172.30.1.18:1521:xe";
	private String uid = "ERP";
	private String upw = "1234";
	
	public List<ManagerVO> application_employment_judgement_page () {
		List<ManagerVO> list = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYMENT_DOCUMENT";
		//서류번호, 신청자, 신청서류, 서류상태, 
		//1.Connector
		Connection conn = null;
		//2.Pstmt
		PreparedStatement pstmt = null;
		//3.ResultSet
		ResultSet rs = null;

		try {
			//DB 연결
			conn = DriverManager.getConnection(url, uid, upw);
			//SQL 실행
			pstmt = conn.prepareStatement(sql);
			//SQL 명령문의 ? 지정
			
			//SELECT 실행
			rs = pstmt.executeQuery();

			//다음값이 있는지 판단
			if(rs.next()) { //true라면 중복이 존재한다.
				String document_number = rs.getString("EMPLOYMENT_DOCUMENT_NUMBER");
				String employee_Id = rs.getString("EMPLOYEE_ID");
				String document_status = rs.getString("CONFIRM");
				
				ManagerVO vo = new ManagerVO(document_number, employee_Id, document_status);
				
				list.add(vo);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//터미널 닫기
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

	

		return list;
	}
	
	public List<ManagerVO> application_salary_judgement_page () {
		List<ManagerVO> list = new ArrayList<>();
		String sql = "SELECT * FROM SALARY_DOCUMENT";
		//서류번호, 신청자, 신청서류, 서류상태, 
		//1.Connector
		Connection conn = null;
		//2.Pstmt
		PreparedStatement pstmt = null;
		//3.ResultSet
		ResultSet rs = null;

		try {
			//DB 연결
			conn = DriverManager.getConnection(url, uid, upw);
			//SQL 실행
			pstmt = conn.prepareStatement(sql);
			//SQL 명령문의 ? 지정
			
			//SELECT 실행
			rs = pstmt.executeQuery();

			//다음값이 있는지 판단
			if(rs.next()) { //true라면 중복이 존재한다.
				String document_number = rs.getString("SALARY_DOCUMENT_NUMBER");
				String employee_Id = rs.getString("EMPLOYEE_ID");
				String document_status = rs.getString("CONFIRM");
				
				ManagerVO vo = new ManagerVO(document_number, employee_Id, document_status);
				
				list.add(vo);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//터미널 닫기
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

	

		return list;
	}
}
