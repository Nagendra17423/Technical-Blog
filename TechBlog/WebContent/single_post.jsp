<%@page import="com.tech.blog.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.Entity"%>
<%@page import="com.tech.blog.entities.Posts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v7.0" nonce="GoOpC2l7"></script>
</head>
<body >
	

	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
	<a href="Index.jsp" class="navbar-brand"> <font class="fa fa-ge"
		style="color: black;"></font>&nbsp;TechBlog
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="profile.jsp"> <font
					class=" fa fa-book"></font>&nbsp;Learn Programming<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item active"><a class="nav-link" href="#"> <font
					class="	fa fa-mobile"></font>&nbsp;Contact
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="#"> <font
					class="fa fa-sticky-note-o" data-toggle="modal"
					data-target="#add-post-details"></font>&nbsp;Add Post
			</a></li>

			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <font class="	fa fa-th-list"></font>
					&nbsp;Categories
			</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Programming</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>

		</ul>
		<ul class="navbar-nav mr-right">
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#profile-toggle"><span class="fa fa-user-circle">&nbsp;&nbsp;
				<c:out value="${user.getName()}"></c:out>
				
				
			
				</span> </a></li>
			<li class="nav-item"><a class="nav-link" href="LogoutServlet"><span
					class="fa fa-sign-out">&nbsp;&nbsp;Logout!</span></a></li>
		</ul>
	</div>
	</nav>

	<!--end navbar  -->
	
	<!-- main body -->
	<div class="container-fluid " >
	
	<div class="row my-4">
	<div class="col-md-6 offset-md-3">
	<div class="card">
	<div class="card-header">
<img src="Blog_pics/<c:out value='${post.getPpic() }' />" class="card-img-top"
					alt="..."></img>
					<hr style="height: 2px; border-width: 0; color: gray; background-color: gray">
					<div class='row my-3'>
					<div class="col-md-8">
					<p>Posted by<a href="#!">&nbsp;<c:out value="${currentusr.getName() }"></c:out></a></p>
					</div>
					<div class="col-md-4">
					<p "><c:out value="${post.getPdate().toLocaleString() }"></c:out> </p>
					</div>
					
					
					</div>
	<h3><center><c:out value="${post.getPtitle() }"></c:out></center></h3>
	<hr style="height: 2px; border-width: 0; color: gray; background-color: gray">
	</div>
	<div class="card-body">
	<p><h3>Blog Content:</h3><c:out value="${post.getPcontent() }"></c:out></p>
	<hr style="height: 2px; border-width: 0; color: gray; background-color: gray">
	<pre><h3>Blog Code:</h3><c:out value="${post.getPcode() }"></c:out></pre>
	</div>
	<div class="card-footer">

<a href="LikeServlet?pid=${post.getPid()} &uid=${post.getUser_id()}">
<button type="button" class="btn btn-outline-primary">
<i class="fa fa-thumbs-up" aria-hidden="true">
</i>&nbsp;&nbsp;<c:out value="${like }"></c:out>
</button>
</a>

	</div>
	<div class="card-footer">
	<div class="fb-comments" data-href="http://localhost:8080/TechBlog/Singlepost?pid=2&amp;user_id=1" data-numposts="20" data-width=""></div>
	</div>
	
	</div>
	
	</div>
	
	
	
	</div>
	
	</div>
	
	
	
	<!--  end of main body -->
	
	
	
	<div class="modal fade" id="profile-toggle" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<img src="pics/<c:out value="${user.getProfile() }"/>"
							class="img-fluid" style="max-width: 150px;" /> <br>
						
						<c:out value="${user.getName() }"></c:out>
						<br>
						<!-- details -->

						<div id="show-data">
							<table class="table">
								<tbody>
									<tr>
										<th scope="row">Email</th>
										<td><c:out value="${user.getEmail() }"></c:out></td>

									</tr>
									<tr>
										<th scope="row">Gender</th>
										<td><c:out value="${user.getGender() }"></c:out></td>

									</tr>
									<tr>
										<th scope="row">About</th>
										<td><c:out value="${user.getAbout() }"></c:out></td>

									</tr>
									<tr>
										<th scope="row">Registered Date</th>
										<td><c:out value="${user.getDate() }"></c:out></td>

									</tr>
								</tbody>
							</table>
						</div>


						<div id="edit-data" style="display: none;">

							<h3 class="mt-3">PLEASE EDIT</h3>
							<form action="EditServlet" method="post"
								enctype="multipart/form-data">
								<table class="table">

									<tr>
										<td>Name</td>
										<td><input type="text" class="form-control"
											value="${user.getName() }" name="user-name"></td>
									</tr>

									<tr>
										<td>Gender</td>
										<td><c:out value="${user.getGender() }"></c:out></td>
									</tr>
									<tr>
										<td>Email</td>
										<td><input type="email" class="form-control"
											value="${user.getEmail() }" name="user-mail"></td>
									</tr>

									<tr>
										<input type="text" name="oldfilename"
											value="${user.getProfile() }" hidden />
										<td>Profile Pic</td>
										<td><input type="file" name="user-pic"
											class="form-control" /></td>
									</tr>
									<tr>
										<td>About</td>
										<td><textarea row="5" class="form-control"
												name="user-about">${user.getAbout() }
						</textarea></td>


									</tr>
									<tr>
										<td>
											<div class="container text-center">
												<input class="btn btn-outline-primary" type="submit"
													value="Update" />
											</div>
										</td>
									</tr>


								</table>
							</form>
						</div>

						<!-- end details -->
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="edit-btn">Edit</button>
				</div>
			</div>
		</div>
	</div>

	<!--  END OF MODAL -->

	<!--start of post modal-->

	<!-- Modal -->
	<div class="modal fade" id="add-post-details" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header primary-background  text-white">
					<h5 class="modal-title" id="exampleModalLabel">Provide Post
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">




					<form action="PostServlet" method="post"
						enctype="multipart/form-data">

						<div class="form-group">
							<select class="form-control" name="choice">
								<option selected disabled>--select Category--</option>
								<%
									PostDao post = new PostDao(new ConnectionProvider());
									ArrayList<Category> categ = post.getCat();
									for (Category cat : categ) {
								%>
								<option value="<%=cat.getCid()%>"><%=cat.getCtitle()%></option>
								<%
									}
								%>
							</select>
						</div>




						<div class="form-group">
							<input type="text" name="title" placeholder=" Enter Posts Title"
								class="form-control" required>
						</div>
						<div class="form-group">
							<textarea class="form-control" name="content"
								placeholder="Enter Content of the Post" style="height: 200px;"></textarea>
						</div>
						<div class="form-group">
							<textarea class="form-control" name="code"
								placeholder="Enter Your Code to Support your content"
								style="height: 200px;"></textarea>
						</div>
						<div class="form-group">
							<label>Upload Pic</label><br> <input type="file" name="pic" />
						</div>

						<div class="form-group">
							<input class="btn btn-outline-primary form-control"
								onclick="func1()" id="postupload" type="Submit" value="upload" />
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- end of post modal -->




	<!-- script -->


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


	<script>
		let editStatus = false;
		$(document).ready(function() {
			$('#edit-btn').click(function() {
				if (editStatus == false) {
					$('#show-data').hide();
					$('#edit-data').show();
					editStatus = true;
					$(this).text("Back");
				} else {
					$('#show-data').show();
					$('#edit-data').hide();
					editStatus = false;
					$(this).text("Edit");
				}
			})
		});
	</script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</body>
</html>