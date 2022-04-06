<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
 <sec:authorize access="isAuthenticated()" >
 	<sec:authentication property="principal" var="principal"/>
 </sec:authorize>
 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  
     <!-- <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<c:choose>
			<%-- <c:when test="${empty sessionScope.principal }"> --%>
			<c:when test="${empty principal }">
			
				<ul class="navbar-nav">
				
				
					<li class="nav-item"><a class="nav-link" href="/auth/loginForm">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link"  href="/auth/signupForm">Signup</a>
					</li>
					
			</ul>
			</c:when>
			<c:otherwise>
			
				<ul class="navbar-nav">
				
					<li class="nav-item"><a class="nav-link" href="/board/writeForm">Write</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/user/userInfo">UserInfo</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
					</li>
					
					</ul>
					</c:otherwise>
			</c:choose>
			
			
			</div>
		</div>
	</nav>
<br>