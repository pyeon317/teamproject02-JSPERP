<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   

    <title>Introduce to HPS World</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet" type="text/css">

    
    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    
    
    
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    });
    </script>
    <style>
    .abc {
        position: sticky;
        top: 0px;
        width: 100%; 
        z-index: 10;
    }
    </style>
    
	<style>
	.carousel-control.left,  
	.carousel-control.right {
	    background-image: linear-gradient(to right, rgba(0, 0, 0, .0001) 0%, rgba(0, 0, 0, 0) 100%);
	}
	</style>
    
    
    
</head>

<body>
    <!-- header -->
    <div class="brand">My ERP</div>        
    <div class="address-bar">Introduce to HPS World</div>
    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My ERP Program</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    
                    <c:choose>
                        <c:when test="${sessionScope.employee_Id != null }">
						<li>
                        	<a href="<%=request.getContextPath() %>/index.jsp" style="font-weight: bold;">HOME</a>
                        </li>
                         <li>
                            <a href="<%=request.getContextPath() %>/announcement/announcement_list.announcement" style="font-weight: bold;">공지사항</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/board/board_list.board" style="font-weight: bold;">자유게시판</a>
                        </li>
                        <li>
                           <a href="<%=request.getContextPath() %>/user/user_management.user" style="color:blue; font-weight: bold;">직원관리</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/user/user_mypage.user" style="color:blue; font-weight: bold;">마이페이지</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/user/user_logout.user" style="color:red; font-weight: bold;">로그아웃</a>
                        </li>
                    
                        </c:when>
                        <c:otherwise>
                        <li>
                            <a href="<%=request.getContextPath() %>/user/user_login.user">LOGIN</a>
                        </li>
                        </c:otherwise>
                    
                    </c:choose>
                    
                    
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- end header -->
</body>
</html>
