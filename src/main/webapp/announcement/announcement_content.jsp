<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>    
    

<div align="center" class="div_center">
	
	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.announcement_number }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${vo.hit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.employee_id }</td>
			
			<td>작성일</td>
			<td >${vo.regdate }</td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.announcement_title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.announcement_content }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='announcement_list.announcement'">&nbsp;&nbsp;
				
				<input type="button" value="수정" onclick="location.href='announcement_modify.announcement?announcement_number=${vo.announcement_number}&employee_id=${vo.employee_id }'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='announcement_delete.announcement?announcement_number=${vo.announcement_number}&employee_id=${vo.employee_id }'">&nbsp;&nbsp;

			</td>
		</tr>
	</table>
	
	
</div>

<%@ include file="../include/footer.jsp" %>    