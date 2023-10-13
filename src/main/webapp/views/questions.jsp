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
<title>Create Question</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/question.css">
</head>
<body>
	<%
	// allow acess only if session exists 
	// the session .getAttribute return object but down cast it o the desired type
	String user = (String) session.getAttribute("user");
	String username = null;
	String role = null;
	String sessionId = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user"))
		username = cookie.getValue();
			if (cookie.getName().equals("JSESSIONID"))
		sessionId = cookie.getValue();
			if (cookie.getName().equals("role"))
		role = cookie.getValue();
		}
	}
	%>
	<div class="row">

		<div class="mx-auto col-10 col-md-8 col-lg-6">
			<%	if (username != null) {%>
			<main class="l-main">
				<h2 class="section-title">
					Welcome to the quiz app
					<%=username%>
					.Your session Id is
					<%=sessionId%></h2>
				<h3 class="section-title">List of questions</h3>
				<form action="<%=request.getContextPath()%>/score" method="post"
					id="questionForm">
					<div class="questions__container bd-grid">
						<!-- List questions using scriptlets and expressions -->
						<%
						List<Questzion> questions = (ArrayList) request.getAttribute("questions");

						Iterator<Questzion> iterator = questions.iterator();
						while (iterator.hasNext()) {
							Questzion question = iterator.next();
							String option1 = question.getOption1();
							String option2 = question.getOption2();
							String option3 = question.getOption3();
							String option4 = question.getOption4();
							String name = String.valueOf(question.getId());
						%>

						<ul class="quiz">
							<li>
								<h4><%=question.getId() + ") " + question.getQuestion()%></h4>

								<ul class="choices">
									<li><label><input type="radio" name=<%=name%>
											value=<%=option1%> /><span><%=question.getOption1()%></span></label></li>
									<li><label><input type="radio" name=<%=name%>
											value=<%=option2%> /><span><%=question.getOption2()%></span></label></li>
									<li><label><input type="radio" name=<%=name%>
											value=<%=option3%> /><span><%=question.getOption3()%></span></label></li>
									<li><label><input type="radio" name=<%=name%>
											value=<%=option4%> /><span><%=question.getOption4()%></span></label></li>
								</ul>
							</li>
						</ul>
						<%
						}
						%>

						<input type="submit" value="Show result" class="btn btn-primary">
						<%
						if (role.equals("admin")) {
						%>
						<%-- <jsp:include page="../views/admin_menu.jsp"/> --%>
						<a href="create-question" class="btn btn-primary">Create
							Question</a>

						<%
						}
						%>
						<a href="logout" class="btn btn-primary">Logout</a>
						<%} %>
						<%if(username==null) {%>
						<h4> Sorry ! Your session is expired click here to play again  <a href="login" class="btn btn-primary">login</a> </h4>
						
						<a href="logout" class="btn btn-primary">Logout</a>
						<%} %>

					</div>
				</form>
			</main>
		</div>
	</div>
</body>
</html>