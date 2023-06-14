<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align="center">
		<h3>승인할 아이디를 입력하시오</h3>
	    <form action="user_emp_judge.user">
	    	재직증명서 승인할 아이디: <input type="text" name="permit_Id" >
	    	<input type="submit" value="승인">
		</form>
 		<form action="user_sal_judge.user" method="post">
	    	급여명세서 승인할 아이디: <input type="text" name="permit_Id" >
	    	<input type="submit" value="승인">
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>