package com.erp.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.erp.announcement.model.AnnouncementVO;
import com.erp.user.model.UserDAO;
import com.erp.user.model.UserVO;

public class UserDAO {

		private static UserDAO instance = new UserDAO();

		private UserDAO() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
			}
		}

		//3.getter를 통해서 객체를 반환
		public static UserDAO getInstance() {

			return instance;
		}

		//데이터베이스 연결주소
		private String url = "jdbc:oracle:thin:@172.30.1.18:1521:xe";
		private String uid = "ERP";
		private String upw = "1234";

		//중복검사
		public int idCheck(String employee_Id) {
			int result = 1;
			//SQL에 전달할 명령문 (ID가 ?인 사람이 있는가?)
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";

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
				pstmt.setString(1, employee_Id);
				//SELECT 실행
				rs = pstmt.executeQuery();

				//다음값이 있는지 판단
				if(rs.next()) { //true라면 중복이 존재한다.
					result=1;
				} else { //false라면 중복이 존재하지 않는다.
					result=0;
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

			return result;
		}

		//회원가입
		public void join(UserVO vo) {
			String sql = "INSERT INTO EMPLOYEES(EMPLOYEE_ID, NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, DEPARTMENT_ID, PASSWORD) VALUES (?, ?, ?, ?, SYSDATE, ?, ?, ?)";

			//1.Connector
			Connection conn = null;
			//2.Pstmt
			PreparedStatement pstmt = null;

			try {
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getEmployee_Id());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getEmail());
				pstmt.setString(4, vo.getPhone_Number());
				pstmt.setString(5, vo.getJob_Id());
				pstmt.setInt(6, vo.getDepartment_Id());
				pstmt.setString(7, vo.getPassword());
				
				pstmt.executeUpdate(); //성공시1, 실패시0
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}

		//로그인
		public UserVO login(String employee_Id, String password) {
			
			//로그인 성공이면 객체 반환
			//로그인 실패면 null 반환
			UserVO vo = null;
			
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? AND PASSWORD = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id);
				pstmt.setString(2, password);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String id2 = rs.getString("employee_Id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone_Number = rs.getString("phone_Number");
					Timestamp hire_Date = rs.getTimestamp("hire_Date");
					String job_Id = rs.getString("job_Id");
					int salary = rs.getInt("salary");
					int commission = rs.getInt("commission");
					int manager_Id = rs.getInt("manager_Id");
					int department_Id = rs.getInt("department_Id");
					String password2 = rs.getString("password");
					
					vo = new UserVO(id2, name, email, phone_Number, hire_Date, job_Id, salary, commission, manager_Id, department_Id, password2);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			return vo;
		}

		//회원정보조회
		public UserVO getInfo(String employee_Id) {
			UserVO vo = null;
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try  {
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id); //id
				
				rs = pstmt.executeQuery(); //id는 pk
				
				if(rs.next()) {
					String id2 = rs.getString("employee_Id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone_Number = rs.getString("phone_Number");
					Timestamp hire_Date = rs.getTimestamp("hire_Date");
					String job_Id = rs.getString("job_Id");
					int salary = rs.getInt("salary");
					int commission = rs.getInt("commission");
					int manager_Id = rs.getInt("manager_Id");
					int department_Id = rs.getInt("department_Id");
					String password2 = rs.getString("password");
					
					vo = new UserVO(id2, name, email, phone_Number, hire_Date, job_Id, salary, commission, manager_Id, department_Id, password2);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			return vo;
		}

		//회원정보수정
		public int updateInfo(UserVO vo) {
			
			String sql = "UPDATE EMPLOYEES SET NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, JOB_ID = ?, PASSWORD = ? WHERE EMPLOYEE_ID = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(url,uid,upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getEmail());
				pstmt.setString(3, vo.getPhone_Number());
				pstmt.setString(4, vo.getJob_Id());
				pstmt.setString(5, vo.getPassword());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			
			return result;
		}

		//급여명세서 신청
		public int applySalary(String employee_Id) {
			String sql = "INSERT INTO SALARY_DOCUMENT(SALARY_DOCUMENT_NUMBER, EMPLOYEE_ID, CONFIRM) VALUES('SAL' || APPLY_SALARY_SEQ.NEXTVAL, ?, 'N' )";
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(url,uid,upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			return result;
		}
		
		//재직증명서 신청
		public int applyEmployment(String employee_Id) {
			String sql = "INSERT INTO EMPLOYMENT_DOCUMENT(EMPLOYMENT_DOCUMENT_NUMBER, EMPLOYEE_ID, CONFIRM) VALUES('EMP' || APPLY_EMPLOYMENT_SEQ.NEXTVAL, ?, 'N' )";
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(url,uid,upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			return result;
		}
		
		//급여명세서 결과
		public String applySalaryResult(String employee_Id) {
			String result = null;
			String sql = "SELECT CONFIRM FROM SALARY_DOCUMENT WHERE EMPLOYEE_ID = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try  {
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id); //id
				
				rs = pstmt.executeQuery(); //id는 pk
				
				if(rs.next()) {
					result = rs.getString("confirm");
				} else {
					result = "no_result";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			return result;
		}
		
		//재직증명서 결과
		public String applyEmploymentResult(String employee_Id) {
			String result = null;
			String sql = "SELECT CONFIRM FROM EMPLOYMENT_DOCUMENT WHERE EMPLOYEE_ID = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try  {
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id); //id
				
				rs = pstmt.executeQuery(); //id는 pk
				
				if(rs.next()) {
					result = rs.getString("confirm");
				} else {
					result = "no_result";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			return result;
		}
				
		//회원탈퇴
		public int withdraw(String employee_Id) {
			String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee_Id);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			
			return result;
		}
		
		public List <UserVO> getList() {

			List <UserVO> list = new ArrayList<>();
			
			String sql = "SELECT employee_Id, name, email, phone_Number, hire_Date, job_Id, department_Id, salary FROM EMPLOYEES";
					
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
					
			try {
						
				conn = DriverManager.getConnection(url, uid, upw);
						
				pstmt = conn.prepareStatement(sql);
						
				rs = pstmt.executeQuery(); //끝
						
				/*
				 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램 코드
				 */
				while(rs.next()) {
					//1행에 대한 처리
					String employee_Id = rs.getString("employee_Id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone_Number = rs.getString("phone_Number");
					Timestamp hire_Date = rs.getTimestamp("hire_Date");
					String job_Id = rs.getString("job_Id");
					int salary = rs.getInt("salary");
					int department_Id = rs.getInt("department_Id");
					
					UserVO vo = new UserVO(employee_Id, name, email, phone_Number, hire_Date, job_Id, salary, 0, 0, department_Id, null);
						
					list.add(vo);
				}
						
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					pstmt.close();
		            conn.close();
		            rs.close();
					
				} catch (Exception e2) {
							
				}
			}
		return list;
		}	
}
