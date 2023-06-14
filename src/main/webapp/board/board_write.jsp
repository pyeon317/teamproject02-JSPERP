<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ include file="../include/header.jsp" %>

<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    String now = sdf.format(date); 
%>
    
<form action="registForm.board" method="post" class="box">
    <div align="center" class="div_center">
        <h3>게시판 작성</h3>
        <table border="1" width="550">
            <tr>
                <td style="padding-left: 0.2cm;">작성자</td>
                <td><!-- 로그인 된 사람만 작성페이지에 진입할 수 있고 작성자는 세션값으로 고정해서 남이 수정하지 못하게 한다. -->
                    <input type="text" name="writer" value="${sessionScope.employee_Id }" readonly="readonly" size="10">
                </td>
            </tr>
            <tr>
                <td style="padding-left: 0.2cm;">작성 날짜</td>
                <td>
                    <%=now %>
                </td>
            </tr>
            <tr>
                <td style="padding-left: 0.2cm;">공개 / 비공개</td>
                <td>
                    <input type="radio" name="public_private" value="y" checked="checked">공개
                    <input type="radio" name="public_private" value="n" >비공개
                </td>
            </tr>
            <tr>
                <td style="padding-left: 0.2cm;">글 제목</td>
                <td>
                    <input type="text" name="post_title" >
                </td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td style="padding-left: 0.2cm;">글 내용</td>
                <td>
                    <textarea rows="10" style="width: 95%;" name="post_content"></textarea>
                </td>
            </tr>
            <tr>
            <tr>
                <td colspan="2" style="text-align: right; padding-right: 0.2cm;">
                	<input type="button" value="자유게시판 목록" onclick="location.href='board_list.board'">
                    <input type="submit" value="게시글 등록">
                    &nbsp;&nbsp;
                </td>
            </tr>
            
        </table>
    </div>
</form>
    
<%@ include file="../include/footer.jsp" %>
