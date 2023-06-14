package com.erp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class BoardDAO {

	//싱글통 형태의 클래스로 생성하는 편이 좋습니다.
	//1. 나 자신의 객체를 Static으로 선언
	private static BoardDAO instance = new BoardDAO();

	//2. 직접 생성하지 못하도록 생성자 제한
	private BoardDAO() {
		//생성자에서 드라이버 클래스 호출
		try {
			//Class.forName("오라클 드라이버");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}
	//3. getter를 통해서 객체를 반환
	public static BoardDAO getInstance() {
		return instance;
	}

	//데이터베이스 연결 주소
	//오라클 커넥터
	private String url = "jdbc:oracle:thin:@172.30.1.18:1521:xe";
	private String uid = "ERP";
	private String upw = "1234";

	//글 등록
	public void regist(String EMPLOYEE_ID, String PUBLIC_PRIVATE, String POST_TITLE, String POST_CONTENT, Timestamp REG_DATE) {

		String sql = "INSERT INTO BOARD(POST_NUMBER, EMPLOYEE_ID, PUBLIC_PRIVATE, POST_TITLE, HIT, POST_CONTENT, REG_DATE) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, EMPLOYEE_ID);
			pstmt.setString(2, PUBLIC_PRIVATE);
			pstmt.setString(3, POST_TITLE);
			pstmt.setString(4, POST_CONTENT);
			pstmt.setTimestamp(5, REG_DATE);

			pstmt.executeUpdate(); //void 메서드 이기에 여기서 끝

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {

			}
		}
	}

	//목록을 조회 (현재 매개변수는 없다. 받아 올 것이 없기에...)
	public List<BoardVO> getList() {

		List<BoardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM BOARD ORDER BY REG_DATE DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			/*
			 * 조회된 데이터를 순서대로 VO에 담고 리스트에 추가하는 프로그램 코드
			 * 위에 작업을 ORM 작업이라 부른다.
			 */
			while(rs.next()) {
				//1행에 대한 처리
				//post_number, employee_id, post_type, public_private, post_title, hit, post_content, reg_date
				String post_number = rs.getString("post_number");
				String employee_id = rs.getString("employee_Id");
				String post_title = rs.getString("POST_TITLE");
				Timestamp reg_date = rs.getTimestamp("reg_date");
				

				BoardVO vo = new BoardVO();
				
				
				vo.setPost_number(post_number);
				vo.setEmployee_id(employee_id);
				vo.setPost_title(post_title);
				vo.setRegdate(reg_date);

				list.add(vo); //list추가			
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}
		}
		return list;
	}

		//글 내용을 조회
		public BoardVO getContent(String post_number) {

			BoardVO vo = null;

			String sql = "select * from board where post_number = ?";

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DriverManager.getConnection(url, uid, upw);

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, post_number);

				rs = pstmt.executeQuery();

				if(rs.next()) {
					String post_number2 = rs.getString("post_number");
					String employee_id = rs.getString("employee_Id");
					String post_title = rs.getString("post_title");
					int hit = rs.getInt("hit");
					String post_content = rs.getString("post_content");
					Timestamp regdate = rs.getTimestamp("reg_date");

					vo = new BoardVO(post_number2, employee_id, null, post_title, hit, post_content, regdate);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
				}
			}
				return vo;
		}
		
		//글 수정기능
		public void update(String POST_NUMBER, String PUBLIC_PRIVATE, String POST_TITLE, String POST_CONTENT, Timestamp REG_DATE) {
			

			String sql = "UPDATE BOARD SET PUBLIC_PRIVATE = ?, POST_TITLE = ?, POST_CONTENT = ?, REG_DATE = ? WHERE POST_NUMBER = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, PUBLIC_PRIVATE);
				pstmt.setString(2, POST_TITLE);
				pstmt.setString(3, POST_CONTENT);
				pstmt.setTimestamp(4, REG_DATE);
				pstmt.setString(5, POST_NUMBER);
				
				pstmt.executeUpdate(); //끝.
			} catch (Exception e) {
				
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			
		}
		
		//글 삭제
		public void delete(String post_number) {
			String sql = "delete from board where post_number = ?";
					
			Connection conn = null;
			PreparedStatement pstmt = null;
					
			try {
				conn = DriverManager.getConnection(url,uid, upw);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, post_number);
						
				pstmt.executeUpdate(); //끝
						
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
							
				}
			}
		}	
		
		public List<BoardVO> search(String search) {

			List<BoardVO> list = new ArrayList<>();

			String sql = "SELECT * FROM BOARD where post_title = ? ORDER BY REG_DATE DESC";

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;


			try {

				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				rs = pstmt.executeQuery();

				/*
				 * 조회된 데이터를 순서대로 VO에 담고 리스트에 추가하는 프로그램 코드
				 * 위에 작업을 ORM 작업이라 부른다.
				 */
				while(rs.next()) {
					//1행에 대한 처리
					//post_number, employee_id, post_type, public_private, post_title, hit, post_content, reg_date
					String post_number = rs.getString("post_number");
					String employee_id = rs.getString("employee_Id");
					String post_title = rs.getString("POST_TITLE");
					Timestamp reg_date = rs.getTimestamp("reg_date");
					

					BoardVO vo = new BoardVO();
					
					
					vo.setPost_number(post_number);
					vo.setEmployee_id(employee_id);
					vo.setPost_title(post_title);
					vo.setRegdate(reg_date);

					list.add(vo); //list추가			
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {

				}
			}
			return list;
		}
		
	}