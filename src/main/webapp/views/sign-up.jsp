<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">

<body>
	<div
		class="container min-vh-100 d-flex justify-content-center align-items-center">
		<div class="row">
			<h1>Welcome to the Quiz App!</h1>
			<h1>Sign up</h1>
			<form action="<%=request.getContextPath()%>/sign-up" method="post"
				id="form_signup">

				<div class="form-group ">
					<label>UserName</label> <input type="text" id="uname"
						name="username" placeholder="username" class="form-control"
						required="required">
				</div>
				<div class="form-group  mb-3">
					<label>email</label> <input type="text" id="pwd" name="email"
						placeholder="email" class="form-control">
				</div>
				<div class="form-group  mb-3">
					<label>Password</label> <input type="password" id="pwd"
						name="password" placeholder="password" class="form-control"
						required="required">
				</div>
				<div class="form-group  mb-3">
					<select class="form-select" name="role" required="required">
						<option selected>select role</option>
						<option value="admin">admin</option>
						<option value="user">user</option>
					</select>
				</div>
				<div>
					<input type="submit" value="Register" class="btn- btn-primary">
					<a href="login" class="btn- btn-primary">Click here if you
						already have an account</a>
				</div>

			</form>
		</div>
	</div>


</body>
</html>