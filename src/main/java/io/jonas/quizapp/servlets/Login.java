package io.jonas.quizapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.jonas.quizapp.dao.UserhDao;
import io.jonas.quizapp.entity.Userh;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);

		// get the user from the database

		UserhDao dao = new UserhDao();
		List<Userh> users = dao.getUserByName(username);
		if (users.size()!=0) {
			Userh user = users.get(0);
			System.out.println("thepassword is : " + user.getPassword());
			if (password.equals(user.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("user", username);
				session.setAttribute("role", user.getRole());
				// setting session to expire in 1 minutes
				session.setMaxInactiveInterval(1 * 60);
				Cookie userCookie = new Cookie("user", username);
				Cookie roleCookie = new Cookie("role", user.getRole());
				userCookie.setMaxAge(1* 60);
				res.addCookie(userCookie);
				res.addCookie(roleCookie);
				res.sendRedirect(req.getContextPath() + "/questions");
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/errorPage.jsp");
				dispatcher.forward(req, res);
			}

		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/errorPage.jsp");
			dispatcher.forward(req, res);
		}
	}

}
