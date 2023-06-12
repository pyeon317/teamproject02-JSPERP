<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>    
    

<div align="center" class="div_center">
	<h3>공지사항 작성</h3>
	<hr>
	
	<form action="registForm.announcement" method="post">
		<table border="1" width="500">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" value="${sessionScope.user_id }" readonly="readonly" size="10">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" >
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 100%;" name="content"></textarea>
				</td>
			</tr>
			
			<tr>
				<td calspan="2">
					<input type = "submit" value = "등록" onclick="">
					&nbsp;&nbsp;
					<input type = "button" value = "목록" onclick="location.href='announcement_list.announcement'">
				</td>
			</tr>
		</table>
	</form>
	
	
	
</div>



<%@ include file="../include/footer.jsp" %>    