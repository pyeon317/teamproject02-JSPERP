<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<%@ include file="../include/header.jsp" %>

	<div class="container">
		<h3>My Web게시판</h3>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>순서</th>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
			
				<c:forEach var="vo" items="${list }" varStatus="x">
				<tr>
					<td>${x.count }</td>
					<td>${vo.bno }</td>
					<td>${vo.writer }</td>
					<!-- board_content.board=상세내역으로 보낸다. -->
					<!-- 키 값 형태로 BNO를 전달 -->
					<td><a href="board_content.board?bno=${vo.bno }">${vo.title }</a></td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd (E) hh시mm분"/></td>
					<td>${vo.hit }</td>
				</tr>
				</c:forEach>
				
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="6" align="right">
						<form action="" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='board_write.board'">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>

<%@ include file="../include/footer.jsp" %>






