<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="components/common.jsp"%>
<%
if(session.getAttribute("current-user")!=null){
	response.sendRedirect("homepage.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
    <div class="container-fluid p-5">
        <div class="row">

            <!-- Actual Form -->
            <div class="col-md-6 pb-md-0 pb-4 ml-auto mr-auto">
                <div class="box-design">
                <%@ include file="components/response.jsp" %>
                    <h1 class="text-center">Register</h1>
                    <h6 class="font fit-width ml-auto mr-3 m-1 ">*Required fields</h6>
                    <form class="pt-4 px-3" action="RegistrationServlet" method="POST">
                        <div class="col">
                            <div class="form-group ">
                                <label for="name">*Name</label>
                                <input type="text" class="form-control " id="name" placeholder="Enter Your Name " name="name" required>
                            </div>

                            <div class="form-group ">
                                <label for="name">*Username</label>
                                <input type="text" class="form-control " id="username" placeholder="Enter Your Username " name="username" required>
                            </div>


                            <div class="form-group ">
                                <label for="password">*Password</label>
                                <input type="password" class="form-control " id="password" placeholder="Enter Your Password" name="password" required>
                            </div>
                        </div>
                        
                        <div class="d-flex justify-content-center ">
                            <button class="btn3 px-4 m-2" onclick="window.location.href = './login.jsp';">Cancel</button>
                       
                            <button type="submit" class="btn1 px-4 m-2">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>