<%@page import="java.util.*"%>
<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="java.util.List"%>
<%@ page import="com.tech.blog.dao.*"%>
<%@ page import="com.tech.blog.helper.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<!-- CSS only -->
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
	<div class="row">

		<%
			PostDao post = new PostDao(new ConnectionProvider());
			int catid = Integer.parseInt(request.getParameter("cid"));
			System.out.println("catid " + catid);
			List<Posts> p = new ArrayList<>();

			if (catid == 0) {
				p = post.getAllPost();
			} else {
				p = post.getPost(catid);
			}
			if (p.size() == 0) {
				out.println("<h3 class='display-3 text-center'>No posts to show...</h3> ");
				return;
			}
			for (Posts p1 : p) {
		%>

		<div class="col-md-6 mt-4 d-flex align-items-stretch">

			<div class="card" style="width: 18rem;">
				<img src="Blog_pics/<%=p1.getPpic()%>" class="card-img-top"
					alt="...">
				<div class="card-body">
					<hr
						style="height: 2px; border-width: 0; color: gray; background-color: gray">
					<h3>Title:</h3>
					<b class="card-title"><%=p1.getPtitle()%></b>

					<!-- <hr style="height:2px;border-width:0;color:gray;background-color:gray">
				<h3>Content:</h3><p class="card-text"><%=p1.getPcontent()%></p>
				<hr style="height:2px;border-width:0;color:gray;background-color:gray">
				<h3>Code:</h3><pre><%=p1.getPcode()%></pre> -->


				</div>
				<div class="card-footer">
					<a href="Singlepost?pid=<%=p1.getPid()%>&user_id=<%=p1.getUser_id() %>" class=class= "btnbtn-outline-primarybtn-sm">Read
						More... &nbsp;&nbsp;&nbsp;</a> 
					
				</div>

			</div>
		</div>
		<%
			}
		%>

	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</body>
</html>