<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rahul.model.User" %>

    <%
User auth = (User) request.getSession().getAttribute("auth");
if(auth != null){
	request.setAttribute("auth",auth);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart Login</title>
<%@ include file="includes/header.jsp" %>
<!-- CSS only -->
<!-- JavaScript Bundle with Popper -->
</head>
<body>
	<%@ include file="includes/navbar.jsp" %>
	
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Sign Up</div>
			<div class="card-body">
				<form action="user-signup" method="post">
					<div class="form-group mb-2">
						<label>Name</label>
						<input class="form-control" name="user-name" type="text" required="required" placeholder="Enter Your Name">
					</div>
					<div class="form-group">
						<label>Email</label>
						<input class="form-control" name="user-email" type="email" required="required" placeholder="Enter The Email">
					</div>
					<div class="form-group mb-2">
						<label>Password</label>
						<input class="form-control" name="user-password" type="password" required="required" placeholder="Enter Your Password">
					</div>
					<div class="text-center mt-2">
						<button type="submit" class="btn btn-primary">Sign Up</button>
					</div>
					
				</form>
			</div>
			
		</div>
	</div>
	
<%@ include file="includes/footer.jsp" %>
</body>
</html>