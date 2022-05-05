<!-- This file contains the Navigation bar used in Homepage-->

<%@page import="com.deloitte.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Navbar</title>
<%@include file="common.jsp"%>


</head>

<%
User u = (User) session.getAttribute("current-user");
%>

<%
if (u != null) {
%>
<body>



	<nav class="navbar navbar-expand-lg navbar-light bg-color">
		<span class="navbar-text text-white navbar-brand "> 
			Welcome <%=u.getName()%>
		</span> 
		
		<a class="ml-auto link2 text-white" href="LogoutServlet">LogOut</a>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>



	</nav>
	<%
	}
	%>
</body>
</html>