<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div align="center" class="container">

	
	<form action="user_act_retire.user" method="post" class="box">
	<table class="table table-bordered"> 
	 	<h3>직 원 명 단</h3>
	 	<thead>
			<tr>
				<th>직원아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>고용일</th>
				<th>직무</th>
				<th>부서</th>
				<th>급여</th>
			</tr>
		</thead>	
		
		
		
		<tbody>
			<c:forEach var="vo" items="${list }" varStatus="x">
				<tr>
					<td>${vo.employee_Id }</td>
					<td>${vo.name  }</td>
					<td>${vo.email }</td>
					<td>${vo.phone_Number }</td>
					<td>${vo.hire_Date }</td>
					<td>${vo.job_Id }</td>
					<td>${vo.department_Id }</td>
					<td>${vo.salary }</td>
					<td><input type="checkbox" name="retirement" value="${vo.employee_Id }">퇴사</td>
				</tr>
			</c:forEach>
		</tbody>
			
		<tbody>
			<tr style="margin-top: 2cm;">
				<td colspan="9" align="right" style="padding-right: 2cm;">	
							<input type="button" value="퇴사자 명단" class="btn btn-default" onclick="location.href='user_retirement.user'">
							<input type="submit" value="퇴사 처리" class="btn btn-default">
			</tr>
		</tbody>
		
		
		
		
	</table>
	</form>	
</div>

</section>

<%@ include file="../include/footer.jsp"%>
