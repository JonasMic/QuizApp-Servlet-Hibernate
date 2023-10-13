package io.jonas.quizapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jonas.quizapp.dao.QuestzionDao;
import io.jonas.quizapp.entity.Questzion;

@WebServlet("/create-question")
public class RegisterQuestion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/create-question.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String question = req.getParameter("question");
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");
		String option3 = req.getParameter("option3");
		String option4 = req.getParameter("option4");
		String answer = req.getParameter("answer");
		// now instantiate the question object with the above values
		Questzion quest = new Questzion();
		quest.setQuestion(question);
		quest.setOption1(option1);
		quest.setOption2(option2);
		quest.setOption3(option3);
		quest.setOption4(option4);
		quest.setAnswer(answer);
		QuestzionDao questionDao = new QuestzionDao();
		try {
			questionDao.createQuestion(quest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/create-question.jsp");
		dispatcher.forward(req, resp);

	}

}
