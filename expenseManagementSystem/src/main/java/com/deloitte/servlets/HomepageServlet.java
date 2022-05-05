package com.deloitte.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dao.ExpenseDAO;
import com.deloitte.entities.Expense;
import com.deloitte.entities.User;

public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Default Constructor
	public HomepageServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// To get the current user
		User u = (User) request.getSession().getAttribute("current-user");

		System.out.println(request.getParameter("expDate"));

		// Creating a new expense object and passing all values in constructor
		Expense exp = new Expense(
				LocalDate.parse(request.getParameter("expDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
				request.getParameter("expType"), request.getParameter("expDesc"),
				Double.parseDouble(request.getParameter("total")), u);

		// returning the expense Id which is being saved in Database
		int eID = ExpenseDAO.saveExpense(exp);
		if (eID > 0) {
			request.getSession().setAttribute("success", "Successfully added with id" + eID);
		} else {
			request.getSession().setAttribute("warning", "Unable to add");
		}

		// Redirecting back to Homepage
		response.sendRedirect("homepage.jsp");

	}

}
