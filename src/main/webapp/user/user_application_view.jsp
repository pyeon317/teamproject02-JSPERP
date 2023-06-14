<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../include/header.jsp"%>
<%
Date date = new Date();
// 현재 날짜와 시간을 포맷팅할 패턴 설정
String pattern = "yyyy-MM-dd";
SimpleDateFormat sdf = new SimpleDateFormat(pattern);

// 현재 날짜와 시간을 포맷에 맞춰서 문자열로 변환
String formattedDate = sdf.format(new Date());
%>
<section>
	<div align="center" class="box">
		<h3>서류결과</h3>
		<c:choose>
			<c:when test="${sessionScope.judgement eq 'employmentY' }">
				<br>
				<h4><b>재직증명서</b></h4>
				<br>
				<b>이름 : ${vo.name }</b>
				<br>
				<b>직무 : ${vo.job_Id }</b>
				<br>
				<b>부서 : ${vo.department_Id }</b>
				<br>
				<b>근속년수: ${fn:substring(vo.hire_Date, 0, 10)} ~ <%=formattedDate%></b>
				<br>
				<br>
				<b>상기와 같이 재직하고 있음을 증명합니다.</b>
				<br>
				<br>
				<b>주식회사 HPS</b>
				<br>
				<b>대표이사 X X X</b> 
				<br>
				<br>
				<br>
				<b>발급일 : <%=formattedDate%></b>
			</c:when>
			<c:when test="${sessionScope.judgement eq 'salaryY' }">
				<br>
				<h4><b>급여명세서</b></h4>
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
				<br>
				<br>
				<b>주식회사 HPS</b>
				<br>
				<b>대표이사 X X X</b> 
				<br>
				<br>
				<br>
				<b>발급일 : <%=formattedDate%></b>
			</c:when>
		</c:choose>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
