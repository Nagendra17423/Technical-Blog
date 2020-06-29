<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
     
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
<c:import url="header.jsp"></c:import>
<main class="d-flex align-items-center primary-background"
		>
<div class="container">
<div class="col-md-6 offset-md-3">
<div class="card">

<div class="card-header primary-background text-white">
						<center>
						<span class="fa fa-user-circle fa-2x"></span>
Register
						</center>
					</div>
					<br>



<div class="card-body">
<form action="RegisterServlet" method="post">
<div class="form-group">
    <label for="name">Name</label>
    <input type="text"  name="name" class="form-control" id="name" >
  </div>

  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email"  name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Gender</label><br>
    <input type="radio" name="gender" value="male">Male&nbsp;&nbsp;&nbsp;
    <input type="radio"  name="gender" value="female">Female
  </div>
  
  <div class="form-group form-check " >
    <label for="exampleInputPassword1">Tell about yourself!</label><br>
    <textarea name="about"  class="form-control" rows="4" cols="20"></textarea>
    
  </div>
  
  <div class="form-group ">
    <input type="checkbox" class="form-check-input " name="check" id="exampleCheck1">
    <label class="form-check-label"  for="exampleCheck1" >Terms and Conditions..</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>


</div>
</div>
</div>
</main>


<script src="https://code.jquery.com/jquery-3.5.1.slim.js"
		integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>