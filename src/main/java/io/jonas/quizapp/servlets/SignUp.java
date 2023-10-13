package io.jonas.quizapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jonas.quizapp.dao.UserhDao;
import io.jonas.quizapp.entity.Userh;

//import javax.crypto.SecretKeyFactory;  
//import javax.crypto.spec.PBEKeySpec;  


@WebServlet("/sign-up")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/sign-up.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String passsword = request.getParameter("password");
		String role = request.getParameter("role");
		// encrypt the password 
		// generate saltvalue
		Userh  user = new Userh();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passsword);
		user.setRole(role);
		UserhDao userDao = new UserhDao();
		try {
			System.out.println(user);
			userDao.createUser(user);
		}catch(Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/views/login.jsp");
		dispatcher.forward(request, response);
	}

}
