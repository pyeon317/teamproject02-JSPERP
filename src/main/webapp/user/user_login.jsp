<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div align="center">
		<h3>로그인 페이지</h3>
		<form action="loginForm.user" method="post">
			<input type="text" name="employee_Id" placeholder="아이디"> <br>
			<input type="password" name="password" placeholder="비밀번호"> <br>
			<input type="submit" value="로그인" >
			<input type="button" value="가입하기" onclick="location.href='user_join.user'">
		</form>
		<div style="color : red">${msg }</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>