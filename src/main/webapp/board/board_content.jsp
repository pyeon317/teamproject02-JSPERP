<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center, box">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.post_number }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${vo.hit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.employee_id }</td>
			
			<td>작성일</td>
			<td>${vo.regdate }</td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.post_title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.post_content }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='board_list.board'">&nbsp;&nbsp;
				
				<!-- 불필요한 목록 숨기기 -->
				<c:if test="${vo.employee_id == sessionScope.employee_Id }">
				<input type="button" value="수정" onclick="location.href='board_modify.board?post_number=${vo.post_number}&writer=${vo.employee_id }' ">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='board_delete.board?post_number=${vo.post_number}'">&nbsp;&nbsp;
				</c:if>
			</td>
		</tr>
	</table>

</div>

<%@ include file="../include/footer.jsp" %>
