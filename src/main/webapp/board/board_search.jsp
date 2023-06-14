<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>

<div align="center" class="container">

    <h3>자 유 게 시 판 - 검색 결과</h3>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>글 번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성날짜</th>
                <th>조회수</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="vo" items="${searchResults}" varStatus="x">
                <tr>
                    <td>${vo.post_number}</td>
                    <td>${vo.employee_id}</td>
                    <td><a href="board_content.board?post_number=${vo.post_number}">${vo.post_title}</a></td>
                    <td><fmt:formatDate value="${vo.regdate}" pattern="MM-dd-yyyy (E) hh시mm분" /></td>
                    <td>${vo.hit}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>

<%@ include file="../include/footer.jsp" %>
