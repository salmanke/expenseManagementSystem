<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="components/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<%
if(session.getAttribute("current-user")!=null){
	response.sendRedirect("homepage.jsp");
	}
%>
</head>
<body>
<div class="container-fluid p-5">
        <div class="row">

            <!-- Actual Login Form -->
            <div class="col-md-6 pb-md-0 pb-4 ml-auto mr-auto">
                <div class="box-design">
                <%@ include file="components/response.jsp" %>
                    <h1 class="text-center">Login</h1>
                    <h6 class="font fit-width ml-auto mr-3 m-1 ">*Required fields</h6>
                    <form class="pt-4 px-3" action="LoginServlet" method="POST">
                        <div class="col">
                            <div class="form-group ">
                                <label for="name">*Username</label>
                                <input type="text" class="form-control " id="name" placeholder="Enter Your Username" name="userName" required>
                            </div>
                            <br>

                            <div class="form-group ">
                                <label for="password">*Password</label>
                                <input type="password" class="form-control " id="password" placeholder="Enter Your Password" name="password" required>
                            </div>
                        </div>

                        <a class="link3 ml-3" href="registration.jsp">New User</a>

                        <div class="d-flex justify-content-center ">
                            <button type="submit" class="btn1 px-4 m-2">Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html>