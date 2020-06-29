<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/mycss.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 86%, 55% 90%, 24% 86%, 0 90%, 0 1%);
}
</style>
</head>
<body>

	<div class="container text-center">

		<p class="display-3">
			<img src="icons/close.png" class="img-fluid " height="80" width="100" />&nbsp;
			&nbsp; &nbsp;&nbsp;Sorry Something Went Wrong!!!
		</p>
		<c:out value="${exception }"></c:out>

		<br> <a href="Index.jsp"
			class="btn primary-background btn-lg text-white mt-3">CLICK TO GO
			HOME</a>
	</div>
</body>
</html>