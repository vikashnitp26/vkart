<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>Welcome! | VKart</title>

<link rel="shortcut icon" href="bootstrap/img/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="bootstrap/img/favicon.ico" type="image/x-icon">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/custom-style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/jquery-3.0.0.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/angular.min.js"></script>
</head>
<body ng-app>
	<%@ include file="Header.jsp"%>

	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<div class="col-md-3">
				<div class="col-md-41">
					<h3 class="">Manage Orders</h3>
					<div class="list-group">
						<a href="account.html" class="list-group-item">All Order</a> <a
							href="account.html" class="list-group-item">Manage Feedback</a> <a
							href="Card" class="list-group-item">My Cards</a> <a
							href="Address" class="list-group-item">My Shipping
							Address</a>
					</div>
				</div>
			</div>
			<!-- Main component for a primary marketing message or call to action -->
			<div class="jumbotron col-md-9">			
				<c:choose>
					<c:when test="${not empty sessionScope.LoggedIn }">
						<h1>Hello! ${sessionScope.Name}?</h1>
						<p class="lead"><h1>${sessionScope.msg}</h1></p>
						
						<p>
							<a class="btn btn-lg btn-primary" href="About" role="button">Learn
								More &raquo;</a>
						</p>
					</c:when>
					<c:otherwise>
						<h1>You are logged out! pls login to continue using our
							services.</h1>
						<p>
							<a class="btn btn-lg btn-primary" href="login" role="button">Login
								in now &raquo;</a>
						</p>
					</c:otherwise>
				</c:choose>

			</div>

		</div>
		<div class="row">
			<h3 class="">My Orders</h3>
			<div class="col-md-8">
				<div class="thumbnail">
					<div class="row">
						<div class="col-sm-1">
							<img class="img-responsive" src="http://placehold.
it/750x600"
								alt="" />
						</div>
										
					<ul class="pagination">
						<li class="disabled"><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>

		</div>
		</div>
		<%@ include file="Footer.jsp"%>
</body>
</html>
