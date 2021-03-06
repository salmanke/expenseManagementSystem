<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.deloitte.entities.*"%>
<%@page import="com.deloitte.dao.*,java.util.List"%>

<%
User user = (User) session.getAttribute("current-user");

List<Expense> allList = null;

if (user == null) {
	session.setAttribute("warning", "You are not logged in");
	response.sendRedirect("login.jsp");
} else {

	allList = ExpenseDAO.fetchExpenseByUserId(user.getId());

	double travel = 0.0, bills = 0.0, medicine = 0.0, food = 0.0, others = 0.0;
	int size = allList.size();

	for (Expense e : allList) {

		switch (e.getType()) {
		case "Travel":
	travel += 1;
	break;
		case "Food":
	food += 1;
	break;

		case "Medicine":
	medicine += 1;
	break;

		case "Bills":
	bills += 1;
	break;

		case "Others":
	others += 1;
	break;
		}
	}

	String expenseType = request.getParameter("expenseType");

	String allSelect = "";
	String travelSelect = "";
	String foodSelect = "";
	String medicineSelect = "";
	String billsSelect = "";
	String otherSelect = "";

	if (expenseType == null) {
		expenseType = "";
	}

	switch (expenseType) {
	case "ALL":
		allSelect = "select";
		break;

	case "Travel":
		travelSelect = "select";
		break;

	case "Food":
		foodSelect = "select";
		break;

	case "Medicine":
		medicineSelect = "select";
		break;

	case "Bills":
		billsSelect = "select";
		break;

	case "Others":
		otherSelect = "select";
		break;

	default:
		allSelect = "select";
		break;

	}

	List<Expense> eList = null;

	if (null == expenseType || "".equals(expenseType) || expenseType.equals("ALL")) {
		eList = ExpenseDAO.fetchLast10Expense(user.getId());
	} else {
		eList = ExpenseDAO.fetchLast10ExpenseType(expenseType, user.getId());
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<%@include file="components/common.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container">
		<%@include file="components/response.jsp"%>

		<div class="container">
			<div class="row d-flex justify-content-around m-3">
				<div class="box1 <%=allSelect%>">
					<a href="homepage.jsp?expenseType=ALL"> All </a>
				</div>

				<div class="box1 <%=travelSelect%>">
					<a href="homepage.jsp?expenseType=Travel"> Travel </a>
				</div>

				<div class="box1 <%=foodSelect%>">
					<a href="homepage.jsp?expenseType=Food"> Food </a>
				</div>

				<div class="box1 <%=medicineSelect%>">
					<a href="homepage.jsp?expenseType=Medicine"> Medicine </a>
				</div>

				<div class="box1 <%=billsSelect%>">
					<a href="homepage.jsp?expenseType=Bills"> Bills </a>
				</div>

				<div class="box1 <%=otherSelect%>">
					<a href="homepage.jsp?expenseType=Others"> Other </a>
				</div>


			</div>


		</div>
		<!-- Button trigger modal -->
		<div class="container custom-border mt-5 p-0">

			<div class="p-2">
				<h4>Expense Report</h4>
			</div>

			<div>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Expense Date</th>
							<th scope="col">Expense Type</th>
							<th scope="col">Expense Description</th>
							<th scope="col">Amount</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						int i = 1;
						for (Expense e : eList) {
						%>
						<tr>
							<th scope="row"><%=i%></th>
							<td><%=e.getDate()%></td>
							<td><%=e.getType()%></td>
							<td><%=e.getDesc()%></td>
							<td><%=e.getAmount()%></td>
							<td><a href="" class="link1" data-toggle="modal"
								data-target="#delete_list"
								onclick="addToModal(<%=e.getId()%>,'<%=expenseType%>')">Delete</a></td>
						</tr>
						<%
						i++;
						}
						%>
					</tbody>
				</table>
			</div>
			<%
			if (eList.size() != 0) {
			%>
			<div class="m-4">
				<div class="progress" style="height: 35px; font-weight: bolder">
					<div class="progress-bar" role="progressbar"
						style="width: <%=((travel / size) * 100.0)%>%">
						Travel (<%=(int) ((travel / size) * 100.0)%>) %
					</div>
					<div class="progress-bar bg-success" role="progressbar"
						style="width: <%=((food / size) * 100.0)%>%">
						Food (<%=(int) ((food / size) * 100.0)%>) %
					</div>
					<div class="progress-bar bg-danger" role="progressbar"
						style="width: <%=((medicine / size) * 100.0)%>%">
						Medicines (<%=(int) ((medicine / size) * 100.0)%>) %
					</div>
					<div class="progress-bar bg-warning" role="progressbar"
						style="width: <%=((bills / size) * 100.0)%>%">
						Bills (<%=(int) ((bills / size) * 100.0)%>) %
					</div>
					<div class="progress-bar bg-secondary" role="progressbar"
						style="width: <%=((others / size) * 100.0)%>%">
						Other (<%=(int) ((others / size) * 100.0)%>) %
					</div>
				</div>
			</div>
			<%
			}
			%>
			<div class="m-2 text-right">
				<button type="button" class="btn btn-danger btn2"
					onclick="showAddExpense()">Add Expense</button>
			</div>


		</div>


		<div class="container custom-border mt-5 p-5 expense">
			<div>
				<h4>Add Expense</h4>
			</div>
			<form ACTION="HomepageServlet" method="post">


				<div class="form-group">

					<label for="expDate" class="row-sm-2 col-form-label">Expense
						Date:</label> <input type="date" id="expDate" class="form-control"
						name="expDate" placeholder="Enter Expense Date" required>
				</div>
				<div class="form-group">
					<label for="expDesc" class="row-sm-2 col-form-label">Expense
						Description:</label>
					<textarea name="expDesc" id="expDesc" class="form-control" rows="5"
						placeholder="Enter Expense Description" required></textarea>
				</div>
				<div class="row ">
					<div class="form-group col-md-6">
						<label for="expType">Expense Type:</label> <select id="expType"
							class="form-control" name="expType">
							<option selected>Travel</option>
							<option>Food</option>
							<option>Medicine</option>
							<option>Bills</option>
							<option>Others</option>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="total">Total:</label> <input type="number" min="1"
							class="form-control" id="total" name="total"
							placeholder="Total Expense" required>
					</div>

				</div>

				<div class=" align-center float-right">
					<button type="reset" class="btn btn-secondary" data-dismiss="modal">Clear</button>
					<button type="submit" class="btn btn-danger"
						onclick="makeAddExpenseDisappear()">Submit</button>
				</div>

			</form>
		</div>

	</div>

	</div>

	<!-- Modal -->
	<div class="modal fade" id="delete_list" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header bg-color text-white">
					<h3 class="modal-title" id="exampleModalLabel">Warning</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="DeleteExpenseServlet" method="get">

					<div class="modal-body">
						<div id="list-body"></div>
						<h5>Are you sure you want to delete !!!</h5>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-danger">Delete</button>
					</div>

				</form>
			</div>
		</div>
	</div>


</body>
</html>
<%
}
%>