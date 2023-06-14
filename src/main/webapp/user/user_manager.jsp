<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div align="center" class="container">

		<form action="user_emp_judge.user" method="post" class="box">
			<table class="table table-bordered">
				<h3>재직증명서 신청 현황</h3>
				<thead>
					<tr>
						<th>문서종류</th>
						<th>직원아이디</th>
						<th>승인여부</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td>${vo.document_number  }</td>
							<td>${vo.employee_id }</td>
							<td><input type="checkbox" name="permit_Id"
								value="${vo.employee_id }">승인</td>

						</tr>
					</c:forEach>
				</tbody>

				<tbody>
					<tr>
						<td colspan="4" align="right">

							<div class="form group">

								<input type="submit" value="결정" class="btn btn-default">

							</div>

						</td>
					</tr>
				</tbody>

			</table>
		</form>
	</div>

	<div align="center" class="container">

		<form action="user_sal_judge.user" method="post" class="box">
			<table class="table table-bordered">
				<h3>급여명세서 신청 현황</h3>
				<thead>
					<tr>
						<th>문서종류</th>
						<th>직원아이디</th>
						<th>승인여부</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="vo" items="${list2 }">
						<tr>
							<td>${vo.document_number  }</td>
							<td>${vo.employee_id }</td>
							<td><input type="checkbox" name="permit_Id"
								value="${vo.employee_id }">승인</td>

						</tr>
					</c:forEach>
				</tbody>

				<tbody>
					<tr>
						<td colspan="4" align="right">

							<div class="form group">

								<input type="submit" value="결정" class="btn btn-default">

							</div>

						</td>
					</tr>
				</tbody>

			</table>
		</form>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>