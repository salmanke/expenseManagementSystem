package com.deloitte.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.dao.UserDAO;
import com.deloitte.entities.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Default Constructor
	public LoginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creating http session
		HttpSession s = request.getSession();

		try {

			// Fetching the entered username and password
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			System.out.println("user >>" + userName);
			System.out.println("password >>" + password);

			// Server side validation to check for empty fields
			if (userName.isEmpty() || password.isEmpty()) {
				System.out.println("invalid");
				return;
			}

			// Checking if the entered details exist in database
			User u = UserDAO.getUserByUsernamePassword(userName, password);

			// If database does not have a match, warning message is displayed
			// and user is redirected to login page
			if (u == null) {
				s.setAttribute("warning", "Invalid details. Recheck credentials");

				response.sendRedirect("login.jsp");
			}

			else {
				// If Database has a match, user is redirected to Homepage
				s.setAttribute("current-user", u);
				response.sendRedirect("homepage.jsp");
			}

		} catch (IOException e) {
			e.printStackTrace();
			// Unsuccessful login attempt redirects user back to Login page
			s.setAttribute("warning", "login unsuccessful due to tech error");
			response.sendRedirect("login.jsp");
		}
	}

}
