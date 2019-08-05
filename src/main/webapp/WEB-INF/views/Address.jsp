<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<title>Address | Vkart</title>

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
	<div class="tab-pane text-style" style="margin-top: 80px;">
		<div style="margin-left: 160px;">
			<h1>Shipping Address</h1>						
		  <div class="row">		  
		  
		    <div class="col-md-4 col-md-offset-4">
		      <form:form method="post" action="addAddress" class="form-horizontal" modelAttribute="address" >
		        <fieldset>
		
		          <!-- Form Name -->
		          <legend>Address Details</legend>
		
		          <!-- Text input-->
		          <div class="form-group">
		            <label class="col-sm-2 control-label" for="textinput">Line 1</label>
		            <div class="col-sm-10">
		              <form:input path="addressLine1" placeholder="Address Line 1" class="form-control" /><form:errors path='addressLine1' />
		            </div>
		          </div>
		
		          <!-- Text input-->
		          <div class="form-group">
		            <label class="col-sm-2 control-label" for="textinput">Line 2</label>
		            <div class="col-sm-10">
		              <form:input type="text" path="addressLine2" placeholder="Address Line 2" class="form-control" />
		            </div>
		          </div>
		
		          <!-- Text input-->
		          <div class="form-group">
		            <label class="col-sm-2 control-label" for="textinput">City</label>
		            <div class="col-sm-10">
		              <form:input type="text" path="city" placeholder="City" class="form-control" /><form:errors path='city' />
		            </div>
		          </div>
		
		          <!-- Text input-->
		          <div class="form-group">
		            <label class="col-sm-2 control-label" for="textinput">State</label>
		            <div class="col-sm-4">
		              <form:input type="text" path="state" placeholder="State" class="form-control"/><form:errors path='state' />
		            </div>
		
		            <label class="col-sm-2 control-label" for="textinput">Postcode</label>
		            <div class="col-sm-4">
		              <form:input type="text" path="pinCode" placeholder="Post Code" class="form-control" /><form:errors path='pinCode' />
		            </div>
		          </div>
		
		
		
		          <!-- Text input-->
		          <div class="form-group">
		            <label class="col-sm-2 control-label" for="textinput">Moboile#</label>
		            <div class="col-sm-10">
		              <form:input type="text" path="phoneNumber" placeholder="Phone Number" class="form-control"/><form:errors path='phoneNumber' />
		            </div>
		          </div>
		
		          <div class="form-group">
		            <div class="col-sm-offset-2 col-sm-10">
		              <div class="pull-right">
		                
		                <button type="submit" class="btn btn-primary">Save</button>
		              </div>
		            </div>
		          </div>
		
		        </fieldset>
		      </form:form>
		    </div><!-- /.col-lg-12 -->
		</div><!-- /.row -->
	</div>
  </div>
</body>
</html>