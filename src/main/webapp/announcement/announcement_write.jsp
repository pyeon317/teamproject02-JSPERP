<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<form action="registForm.announcement" method="post" class="box">
	<div align="center" class="div_center">
		<h3>공지사항 작성</h3>
		<table border="1" width="550">
			<tr>


				<td style="padding-left: 0.2cm;">작성자</td>
				<td><input type="text" name="employee_id" value="${sessionScope.employee_Id }" readonly="readonly" size="10">

				</td>
			</tr>
			<tr>
				<td style="padding-left: 0.2cm;">제목</td>
				<td><input type="text" name="announcement_title"></td>
			</tr>
			<tr>
				<td style="padding-left: 0.2cm;">글 내용</td>
				<td><textarea rows="10" style="width: 100%;" name="announcement_content"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td align="right" style="padding-right: 0.2cm;">
					<input type="button" value="공지사항 목록" onclick="location.href='announcement_list.announcement'">
					<input type="submit" value="공지사항 등록" onclick="">
					&nbsp;&nbsp;
					
				</td>
			</tr>
		</table>
	</div>
</form>

<%@ include file="../include/footer.jsp"%>
