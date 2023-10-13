<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="io.jonas.quizapp.entity.Questzion"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/question.css">
</head>
<body>

	<div>
		<%
		int score = (int) request.getAttribute("score");
		List<Questzion> questions = (ArrayList) request.getAttribute("questions");
		double percentageScore = (score * 100) / questions.size();
		System.out.println(percentageScore);
		String percent = String.format("%.1f", percentageScore);
		%>

		<h1 class="mb-4">
			Your total score is :
			<%=score%>
			out of
			<%=questions.size()%>
			questions.

		</h1>
		<h2>
			<%if(percentageScore>=80){ %>
			
			<b style=color:red>Well Done !</b> Your percentage score is:
			<%=percent%>
			out of 100.<%} %>
			
			<%if(percentageScore<80){ %>
			
			 Your percentage score is:
			<%=percent%>
			out of 100.<%} %>
		</h2>

		<div>
			<h4>
				To Play Again!<a href="questions" class="btn btn-success ">Click
					here!</a>
			</h4>
			<a href="logout" class="btn btn-primary">Logout</a>
		</div>

	</div>

</body>
</html>