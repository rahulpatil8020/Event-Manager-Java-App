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
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="user-login" method="post">
					<div class="form-group mb-2">
						<label>Email Address</label>
						<input class="form-control" name="login-email" type="email" required="required" placeholder="Enter Your Email">
					</div>
					<div class="form-group">
						<label>Password</label>
						<input class="form-control" name="login-password" type="password" required="required" placeholder="Enter The Password">
					</div>
					<div class="text-center mt-2">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
					<a href="signup.jsp">Create An Account</a>
				</form>
			</div>
			
		</div>
	</div>
	
<%@ include file="includes/footer.jsp" %>
</body>
</html>