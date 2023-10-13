<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Question</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div class="row">

		<div class="mx-auto col-10 col-md-8 col-lg-6">
			<h1>Create a question...</h1>
			<form class="form"
				action="<%=request.getContextPath()%>/create-question" method="post">

				<div class="form-group">
					<label>Question:</label> <input type="text" class="form-control "
						id="question" placeholder="Write your question here ..."
						name="question" required="required"/>
				</div>

				<div class="form-group">
					<label>Option 1</label> <input type="text" class="form-control "
						id="option1" placeholder="Write the choice here ..."
						name="option1" required="required"/>
				</div>

				<div class="form-group">
					<label>Option 2</label> <input type="text" class="form-control "
						id="option2" placeholder="Write the choice here ..."
						name="option2" required="required"/>
				</div>

				<div class="form-group">
					<label>Option 3</label> <input type="text" class="form-control "
						id="option3" placeholder="Write the choice here..." name="option3" required="required"/>
				</div>

				<div class="form-group">
					<label>Option 4</label> <input type="text" class="form-control "
						id="option4" placeholder="Write the choice here ..." name="option4" required="required"/>
				</div>

				<div class="form-group">
					<label>Correct Answer:</label> <input type="text"
						class="form-control " id="answer"
						placeholder="Write the correct Answer ..." name="answer" required="required"/>
				</div>
					<button type="submit" class="btn btn-primary btn-customized mt-4">
						Submit</button>
						<!-- the href directs and maps the request to the GetQuestions.java servlet with mapping of /questions -->
					<a href="questions" class="btn btn-primary mt-4 float-right">Go
						To Question List</a>


			</form>
		</div>
	</div>
</body>
</html>