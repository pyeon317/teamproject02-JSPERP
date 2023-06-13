<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align="center">
		<h3>회원정보 페이지</h3>
		${sessionScope.employee_Id }
		<b>(${sessionScope.name }) 님의 정보를 관리중입니다.</b> <br>
		
		<c:choose>
			<c:when test="">
				<b><a href="user_application.user">서류신청</a></b> <br>
				<b><a href="user_application_salary_judgement.user">급여명세서 서류결과</a></b> 
				<b><a href="user_application_employment_judgement.user">재직증명서 서류결과</a></b> <br>
				<b><a href="user_modify.user">회원수정</a> </b>
				<b><a href="user_withdraw.user">회원탈퇴</a></b> <br>
			</c:when>
			<c:when test="">
				<b><a href="manager_application_judgement_page.user">서류검토</a></b> <br>
				<b><a href="user_modify.user">회원수정</a> </b>
				<b><a href="user_withdraw.user">회원탈퇴</a></b> <br>			
			</c:when>
		</c:choose>
		
	</div>
</section>
<%@ include file="../include/footer.jsp"%>