<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align="center">
	<h3>서류검토 리스트</h3>
	*SAL은 급여명세서 EMP는 재직증명서
	</div>
	
	<div align="left">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>서류번호</th>
					<th>신청자</th>
					<th>서류상태</th>
					<th>허가</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="list1" items="${list1 }">
					<tr>
						<td>${list1.document_number }</td>
						<td>${list1.employee_Id }</td>
						<td>${list1.document_status }</td>
						<td><input type="checkbox" name="permit" value=<%= %>></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div align="right">
	
	</div>
</section>
<%@ include file="../include/footer.jsp"%>