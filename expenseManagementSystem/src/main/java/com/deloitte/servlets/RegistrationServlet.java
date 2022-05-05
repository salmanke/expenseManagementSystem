package com.deloitte.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deloitte.dao.UserDAO;
import com.deloitte.entities.User;
import com.deloitte.util.HibernateHelper;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Default constructor
	public RegistrationServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creating a Http Session
		HttpSession s = request.getSession();

		try {
			// Fetches the entered details
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// Checking if the entered username already exists in database. If not,
			// register.
			if (UserDAO.getUserByUserName(username) == null) {

				User user = new User(name, username, password);

				// Creating a new Session object to save the entered details
				SessionFactory sf = HibernateHelper.getInstance();
				Session hibernateSession = sf.openSession();
				Transaction trans = hibernateSession.beginTransaction();

				// Creates a unique user ID for every user
				int uId = (int) hibernateSession.save(user);
				trans.commit();
				hibernateSession.close();
				if (uId > 0) {
					s.setAttribute("success", "User successfully registered. ID is -" + uId);
				} else {
					s.setAttribute("warning", "Cannot add User");
				}
				// Redirect back to Login page
				response.sendRedirect("login.jsp");
				
			} else {
				// If entered username already exists, warning message is displayed and user is
				// redirected back to registration page
				s.setAttribute("warning", "User with the username already registered select different username");
				response.sendRedirect("registration.jsp");
			}
		}

		catch (IOException e) {
			e.printStackTrace();

		}

	}

}
