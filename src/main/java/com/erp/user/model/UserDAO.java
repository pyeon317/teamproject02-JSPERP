package com.erp.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.erp.announcement.model.AnnouncementVO;
import com.erp.document.model.DocumentVO;
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
			pstmt.setString(6, vo.getEmployee_Id());

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

	//재직증명서 서류 승인
	public int application_emp_judgement(String permit_Id) {
		int result = 0;
		String sql = "UPDATE EMPLOYMENT_DOCUMENT SET CONFIRM = 'Y' WHERE EMPLOYEE_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, permit_Id);
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

	//급여명세서 서류 승인
	public int application_sal_judgement(String permit_Id) {
		int result = 0;
		String sql = "UPDATE SALARY_DOCUMENT SET CONFIRM = 'Y' WHERE EMPLOYEE_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, permit_Id);

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

	//직원관리(현직자 명단) 테이블
	public List<UserVO> getList() {

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
	
	//퇴사 처리(퇴사자 목록으로 이동)
	public int retire(String[] retirement) {
		int result = 0;
		String sql = "insert when employee_Id = ? then \r\n"
				+ "into retirement values(employee_Id, name, email, phone_Number, hire_Date, job_Id, SALARY,department_Id )\r\n"
				+ "select employee_Id, name, email, phone_Number, hire_Date, job_Id, SALARY, department_Id from employees";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			for(int i = 0; i < retirement.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, retirement[i]);
				result = pstmt.executeUpdate(); //끝
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

				pstmt.close();
				conn.close();

			} catch (Exception e2) {

			}
		}

		return result;
	}

	//현직 목록에서 삭제
	public void delete(String[] retirement) {

		String sql = "delete from employees where employee_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			for(int i = 0; i < retirement.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, retirement[i]);
				pstmt.executeUpdate(); //끝
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

				pstmt.close();
				conn.close();

			} catch (Exception e2) {

			}
		}

	}

	//퇴사자 명단 테이블
	public List<UserVO> getRetirementList() {

		List <UserVO> list = new ArrayList<>();

		String sql = "SELECT * FROM retirement";

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

	//재직증명서 관리 테이블
	public List<DocumentVO> getDocumentList() {

		List <DocumentVO> list = new ArrayList<>();

		String sql1 = "SELECT * FROM EMPLOYMENT_DOCUMENT WHERE CONFIRM = 'N'";
		

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;


		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt1 = conn.prepareStatement(sql1);

			rs1 = pstmt1.executeQuery(); //끝

			
			while(rs1.next()) {
				//1행에 대한 처리
				String employment_document_number = rs1.getString("employment_document_number");
				String employee_Id = rs1.getString("employee_Id");
				String confirm = rs1.getString("confirm");
				
				DocumentVO vo = new DocumentVO(employment_document_number, employee_Id, confirm);

				list.add(vo);
			}
			
	

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

				pstmt1.close();
				
				conn.close();
				rs1.close();
				

			} catch (Exception e2) {

			}
		}

		return list;
	}
	
	//급여명세서 관리 테이블
		public List<DocumentVO> getsalDocumentList() {

			List <DocumentVO> list = new ArrayList<>();

			
			String sql2 = "SELECT * FROM SALARY_DOCUMENT WHERE CONFIRM = 'N'";

			Connection conn = null;
			
			PreparedStatement pstmt2 = null;
			ResultSet rs2 = null;

			try {

				conn = DriverManager.getConnection(url, uid, upw);

				

				pstmt2 = conn.prepareStatement(sql2);
				
				rs2 = pstmt2.executeQuery();
				
				
				
				while(rs2.next()) {
					//1행에 대한 처리
					String salary_document_number = rs2.getString("salary_document_number");
					String employee_Id = rs2.getString("employee_Id");
					String confirm = rs2.getString("confirm");
					
					DocumentVO vo = new DocumentVO(salary_document_number, employee_Id, confirm);
					
					list.add(vo);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {

					
					pstmt2.close();
					conn.close();
					
					rs2.close();

				} catch (Exception e2) {

				}
			}

			return list;
		}   
}
