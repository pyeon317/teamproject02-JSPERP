<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<form action="user_update.user" method="post" class="container box">
		<div align="center">
			<h3>회원정보 수정</h3>
			<b>${sessionScope.name }님 회원정보를 수정합니다.</b>
			<table border="1">
				<tr>
					<td>아이디</td>

					<td><input type="text" name="employee_Id"
						value="${vo.employee_Id }" readonly="readonly"></td>

				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" required="required"
						pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="name" value="${vo.name }"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${vo.email }"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone_Number" value="${vo.phone_Number }"></td>
				</tr>
				<tr>
					<td>입사날짜</td>
					<td><input type="text" name="hire_Date" value="${vo.hire_Date }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>직무</td>
					<td><input type="text" name="job_Id" value="${vo.job_Id }" readonly="readonly"></td>
				</tr>
			</table>
			<input type="submit" value="정보수정"> <input type="button"
				value="회원페이지로 가기" onclick="location.href='user_mypage.user'">
	</div>
	</form>

</section>
<%@ include file="../include/footer.jsp"%>