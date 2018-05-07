<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


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
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- Loading the home page -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicks on Products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Display the single project.jsp -->
			<c:if test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
		</div>

		<!-- /.container -->
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Data Table Plugin-->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Data Table Bootstrap Script-->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- Linking myapp.js file -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>