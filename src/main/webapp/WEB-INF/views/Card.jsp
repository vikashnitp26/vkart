<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Card | Vkart</title>
<link rel="shortcut icon" href="bootstrap/img/favicon.ico" type="image/x-icon">
		<link rel="icon" href="bootstrap/img/favicon.ico" type="image/x-icon">
<meta charset="ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/custom-style.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/simple-sidebar.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/fonts/font-awesome-4.6.3/css/font-awesome.min.css"
	rel="stylesheet">

<script src="bootstrap/js/jquery-3.0.0.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="bootstrap/js/angular.min.js" type="text/javascript"></script>


</head>
<body>
<%@ include file="Header.jsp"%>
<div class="container" style="margin-top: 80px;margin-left: 480px;">
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form role="form" modelAttribute="card">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <form:input class="form-control" id="cardNumber" path="cardNumber" placeholder="Valid Card Number" />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cardName">
                            Name on Card</label>
                        <div class="input-group">
                            <form:input type="text" class="form-control" id="nameOnCard" path="nameOnCard" placeholder="Name" />
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <form:input type="text" class="form-control" path="expiryMonth" id="expityMonth" placeholder="MM"  />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <form:input type="text" class="form-control" path="expiryYear" id="expityYear" placeholder="YY"  /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CV" required >
                            </div>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
            
            <%
            String b= (String)session.getAttribute("fromOrder");
            if(b!=null && b=="true") {
            	session.setAttribute("fromOrder","false");
            %>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon">Rs.</span>${totalAmount }</span> Final Payment</a>
                </li>
            </ul>
            <br/>
            <a href="checkOut" class="btn btn-success btn-lg btn-block" role="button">Pay</a>
            <%} %>
        </div>
    </div>
</div>

</body>
</html>