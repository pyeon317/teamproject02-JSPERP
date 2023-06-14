<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align="center">
		<h3>회원가입</h3>
		<form action="joinForm.user" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="employee_Id" required="required" pattern="\w{3,}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" required="required" pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone_Number"></td>
				</tr>
				<tr>
					<td>직무</td>
					<td><input type="text" name="job_Id"></td>
				</tr>
				<tr>
					<td>부서</td>
					<td><input type="text" name="department_Id"></td>
				</tr>
			</table>
			
			<div style="color:red;">${msg }</div>
			
			<input type="submit" value="가입">
			<input type="reset" value="정보초기화">
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>