<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div
		class="container min-vh-100 d-flex justify-content-center align-items-center">

		<div class="row">
			<h3>You are successfully logged out!.</h3>
			<h1>Login</h1>
			<form action="<%=request.getContextPath()%>/login" method="post"
				id="form_signup">

				<div class="form-group ">
					<label>UserName</label> <input type="text" id="uname"
						name="username" placeholder="username" class="form-control"
						required="required">
				</div>

				<div class="form-group  mb-3">
					<label>Password</label> <input type="password" id="pwd"
						name="password" placeholder="password" class="form-control"
						required="required">
				</div>

				<div>
					<input type="submit" value="Login" class="btn btn-primary">
					<a href="sign-up" class="btn- btn-primary">Click here if you do
						not have an account</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>