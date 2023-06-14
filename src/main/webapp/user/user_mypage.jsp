<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
    .button-spacing {
        margin-right: 1cm;
    }
</style>

<section>
    <div align="center" class="container box">
        <h3>회원정보 페이지</h3>
        <table>
            <tr>
                <td><font color="purple">${sessionScope.employee_Id }</td>
                <td><b><font color="purple">(${sessionScope.name }) 님의 정보를 관리중입니다.</b></td>
            </tr>
        </table>
    </div>
</section>

<section>
    <div align="center" class="container box">
        <h3>회원정보 수정 및 탈퇴</h3>
        <table>
            <tr>
                <td><input type="button" value="회원수정" onclick="location.href='user_modify.user'" class="button-spacing"></td>
                <td><input type="button" value="회원탈퇴" onclick="location.href='user_withdraw.user'"></td>
            </tr>
        </table>
    </div>
</section>

<section>
    <div align="center" class="container box">
        <h3>서류 관리</h3>
        <table>
            <tr>
                <td><input type="button" value="서류신청" onclick="location.href='user_application.user'" class="button-spacing"></td>
                <td><input type="button" value="급여명세서 서류결과" onclick="location.href='user_application_salary_judgement.user'" class="button-spacing"></td>
                <td><input type="button" value="재직증명서 서류결과" onclick="location.href='user_application_employment_judgement.user'" class="button-spacing"></td>
                <td><input type="button" value="서류 승인(관리자)" onclick="location.href='user_application_judgement.user?employee_Id=${sessionScope.employee_Id }'"></td>
            </tr>
        </table>
    </div>
</section>

<%@ include file="../include/footer.jsp"%>
