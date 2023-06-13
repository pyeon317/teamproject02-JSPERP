<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align="center">
		<h3>서류 신청</h3>
		${sessionScope.employee_Id }
		<b>(${sessionScope.name }) 님 필요한 서류를 선택하세요.</b> <br>
		<form action="user_salary_document_apply.user">
			<input type="submit" value="재직증명서">
		</form>
		<form action="user_employment_document_apply.user">
			<input type="submit" value="급여명세서">
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>