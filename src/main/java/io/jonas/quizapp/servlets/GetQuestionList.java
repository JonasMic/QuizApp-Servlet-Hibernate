package io.jonas.quizapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jonas.quizapp.dao.QuestzionDao;
import io.jonas.quizapp.entity.Questzion;


@WebServlet("/questions")
public class GetQuestionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// call the DAO Layer
		QuestzionDao questionDao = new QuestzionDao();
		List<Questzion> questionList= questionDao.getQuestions();
		System.out.println(questionList);
		// write the question data back to the client browser
		req.setAttribute("questions", questionList);
		req.getRequestDispatcher("./views/questions.jsp").forward(req, resp);
	}

	

}
