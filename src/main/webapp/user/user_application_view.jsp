
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
Date date = new Date();
%>
<section>
	<div align="center">
		<h3>서류결과</h3>
		<c:choose>
			<c:when test="${sessionScope.judgement eq 'employmentY' }">
				<b>재직증명서</b>
				<br>
				<b>이름 : ${vo.name }</b>
				<br>
				<b>직무 : ${vo.job_Id }</b>
				<br>
				<b>부서 : ${vo.department_Id }</b>
				<br>
				<b>근속년수 : ${vo.hire_Date } ~ <%=date%></b>
				<br>
			</c:when>
			<c:when test="${sessionScope.judgement eq 'salaryY' }">
				<b>급여명세서</b>
				<br>
				<b>이름 : ${vo.name }</b>
				<br>
				<b>직무 : ${vo.job_Id }</b>
				<br>
				<b>부서 : ${vo.department_Id }</b>
				<br>
				<b>월급 및 상여 : ${vo.salary } | ${vo.commission }</b>
				<br>
				<b>총 : ${vo.salary + (vo.salary * vo.commission) }</b>
				<br>
			</c:when>
		</c:choose>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>