<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 상대 경로로 적어야한다. -->
<%@ include file="../include/header.jsp"%>


<div class="container">

	<div class="row ">


		<div class="box">


			<div class="col-lg-6 text-center">
				<h2>Welcome</h2>
				<p>우리의 ERP가 궁금하다면?</p>
				<hr>
				<h3>
					<a href="https://www.youtube.com/DOUZONEERP">둘러보기</a>
				</h3>


				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

					<ol class="carousel-indicators hidden-xs">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
					</ol>


					<div class="carousel-inner">
						<div class="item active">
							<img class="img-responsive img-full" src="img/a1.png">
						</div>
						
						<div class="item">
							<img class="img-responsive img-full" src="img/a2.png">
							<!-- img-full 옵션 class -->
						</div>
						
						<div class="item">
							<img class="img-responsive img-full" src="img/a3.png">
						</div>
						
						<div class="item">
							<img class="img-responsive img-full" src="img/a4.png">
						</div>
						<div class="item">
							<img class="img-responsive img-full" src="img/a5.png">
						</div>

					</div>


					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span class="icon-prev"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span class="icon-next"></span>
					</a>
				</div>

			</div>

			<div class="col-lg-6 text-center">

				<h2>HELLO ERP</h2>
				<p>교육을 듣고 가는 건 어때요?</p>
				<hr>
				<h3>
					<a href="https://www.youtube.com/playlist?list=PLm6IqhEHK5aWCmzaSz5YZRytT9B9XNwN8">교육 전체 보기</a>
				</h3>
				<iframe width="540" height="322" 
					src="https://www.youtube.com/embed/Nej_RlOOO2U" 
					title="YouTube video player" frameborder="0" 
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
					allowfullscreen></iframe>
					
			</div>
		</div>
	</div>

	<!-- /.container -->
</div>

<!-- 상대 경로로 적어야한다. -->
<%@ include file="../include/footer.jsp"%>
