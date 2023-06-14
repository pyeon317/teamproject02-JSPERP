<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../include/header.jsp"%>

<form action="board_update.board" method="post" class="box">
	<div align="center" class="div_center">
		<h3>자유게시판 게시글 수정</h3>



		<input type="hidden" name="post_number" value="${vo.post_number }">
		<table border="1" width="500">

			<!-- 화면에서 보여질 필요는 없지만, 데이터 form으로 전송해야할 때
				input태그의 hidden 속성을 씁니다. 
			-->

			<tr>
				<td>작성자</td>
				<td><input type="text" name="post_writer"
					value="${vo.employee_id }" readonly></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${vo.regdate }"
						pattern="MM-dd-yyyy (E) hh시mm분" /></td>
			</tr>
			<tr>
				<td>공개 / 비공개</td>
				<td><input type="radio" name="public_private" value="y"
					checked="checked">공개 <input type="radio"
					name="public_private" value="n">비공개</td>
			</tr>
			<tr>
			<tr>
				<td>글 제목</td>
				<td><input type="text" name="post_title"
					value="${vo.post_title }"></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea rows="10" style="width: 95%;" name="post_content">${vo.post_content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록"
					onclick="location.href='board_list.board'"></td>
			</tr>

		</table>
</form>

</div>

<%@ include file="../include/footer.jsp"%>
