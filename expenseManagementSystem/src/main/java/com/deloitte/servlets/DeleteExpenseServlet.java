package com.deloitte.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dao.ExpenseDAO;
import com.deloitte.entities.Expense;
import com.deloitte.entities.User;

public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Default constructor
	public DeleteExpenseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Gets the current user details in the session
		User u = (User) request.getSession().getAttribute("current-user");
		// Prints the expense ID to be deleted
		System.out.println(request.getParameter("expenseId"));
		// Fetching the expense ID that has to be deleted
		Expense expense = ExpenseDAO.fetchExpenseById(Integer.parseInt(request.getParameter("expenseId")));
		// Checking if fetched expense ID belongs to the same user who is logged in
		if (expense.getUser().getUserName().equals(u.getUserName())) {
			ExpenseDAO.deleteExpense(expense);
		} else {
			request.getSession().setAttribute("warning", "Invalid Operation Type");
		}

		// Redirects back to samepage
		response.sendRedirect("homepage.jsp?expenseType=" + request.getParameter("expenseType"));

	}
}
