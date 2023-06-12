<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>    
    

<div align="center" class="div_center">
	
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="announcement_update.announcement" method="post">
		
		<!-- 
			화면에서 보여질 필요는 없지만, 데이터는 form으로 전송해야할 때
			input태그의 hidden속성을 씁니다
			 -->
			 <input type = "hidden" name="bno" value="${vo.announcement_number }">
			 
		
		<table border="1" width="500">
			
			<tr>
				<td>글 번호</td>
				<td>${vo.announcement_number }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${vo.writer }" readonly></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="title" value="${vo.announcement_title }">
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 100%;" name="content">${vo.announcement_content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='announcement_list.announcement'">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>



<%@ include file="../include/footer.jsp" %>    