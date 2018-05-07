<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
	${contextRoot} says -${greeting}
</body>
</html> --%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	// This is kind of a global variable which is directly linked to window object of a browser
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<!--  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Linking themes -->
<link href="${css}/bootstrap-lux-theme.css" rel="stylesheet"> 

<!-- Linking themes -->
<%-- <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> --%>
<!-- Data table CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">



</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${contextRoot}/home">Online shopping</a>
	            </div>
			</div>
		</nav>
			

		<!-- Page Content -->
		<div class="content">
						<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr/>
							<blockquote style="word-wrap:break-word">
								${errorDescription}
							</blockquote>						
						</div>
					</div>					
				</div>
			</div>
		
		</div>

		<!-- /.container -->
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
	</div>
</body>

</html>