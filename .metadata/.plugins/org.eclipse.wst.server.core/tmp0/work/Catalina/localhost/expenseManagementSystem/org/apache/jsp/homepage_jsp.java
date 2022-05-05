/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.53
 * Generated at: 2021-10-21 10:31:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.deloitte.entities.*;
import com.deloitte.dao.*;
import java.util.List;
import com.deloitte.entities.User;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/components/response.jsp", Long.valueOf(1634808247323L));
    _jspx_dependants.put("/components/navbar.jsp", Long.valueOf(1634808247322L));
    _jspx_dependants.put("/components/common.jsp", Long.valueOf(1634808247321L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.deloitte.dao");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.deloitte.entities");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.deloitte.entities.User");
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");

User user = (User) session.getAttribute("current-user");


List<Expense> allList = null;
String word = "deleteExpense";
if(user==null){
	session.setAttribute("warning","You are not logged in");
	response.sendRedirect("login.jsp");
}else{


allList = ExpenseDAO.fetchExpenseByUserId(user.getId());

double travel=0.0 , bills =0.0, medicine =0.0, food=0.0, others =0.0;
int size = allList.size();

for(Expense e:allList){
	
	switch (e.getType())
	{
		case "Travel" :
			travel +=1;	
			break;
		case "Food" :
			food +=1;
			break;
			
		case "Medicine":
			medicine +=1;
			break;
			
		case "Bills" :
			bills +=1 ;
			break;
			
		case "Others" :
			others +=1 ;
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

if(expenseType == null){
	expenseType = "";
}

switch(expenseType){
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



if(null== expenseType || "".equals(expenseType)  || expenseType.equals("ALL")){
	eList = ExpenseDAO.fetchLast10Expense(user.getId());
}else{
	eList = ExpenseDAO.fetchLast10ExpenseType(expenseType, user.getId());
}


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>HomePage</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"js/script.js\" type=\"text/javascript\"></script>   \r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Navbar</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"js/script.js\" type=\"text/javascript\"></script>   \r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

User u = (User) session.getAttribute("current-user");

      out.write("\r\n");
      out.write("\r\n");

if (u != null) {

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg navbar-light bg-color\">\r\n");
      out.write("		<span class=\"navbar-text text-white navbar-brand \"> \r\n");
      out.write("			Welcome ");
      out.print(u.getName());
      out.write("\r\n");
      out.write("		</span> \r\n");
      out.write("		\r\n");
      out.write("		<a class=\"ml-auto link2 text-white\" href=\"LogoutServlet\">LogOut</a>\r\n");
      out.write("		\r\n");
      out.write("		<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("			data-target=\"#navbarText\" aria-controls=\"navbarText\"\r\n");
      out.write("			aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("			<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("		</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	</nav>\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"js/script.js\" type=\"text/javascript\"></script>   \r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\">");
      out.write("\r\n");
      out.write("\r\n");

	String warning =  (String) session.getAttribute("warning");
	String success = (String) session.getAttribute("success");
	
	if(warning != null){

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n");
      out.write("  <strong>");
      out.print( warning );
      out.write("</strong> \r\n");
      out.write("  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n");
      out.write("    <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("  </button>\r\n");
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
 session.removeAttribute("warning");
} else if(success != null) {
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n");
      out.write("  <strong>");
      out.print( success );
      out.write("</strong> \r\n");
      out.write("  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n");
      out.write("    <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("  </button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
 } session.removeAttribute("success"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<div class=\"row d-flex justify-content-around m-3\">\r\n");
      out.write("		<div class=\"box1 ");
      out.print( allSelect );
      out.write("\">\r\n");
      out.write("			<a href=\"homepage.jsp?expenseType=ALL\"> All </a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"box1 ");
      out.print( travelSelect );
      out.write("\">\r\n");
      out.write("			<a href=\"homepage.jsp?expenseType=Travel\"> Travel </a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"box1 ");
      out.print( foodSelect );
      out.write("\">\r\n");
      out.write("			<a href=\"homepage.jsp?expenseType=Food\"> Food </a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"box1 ");
      out.print( medicineSelect );
      out.write("\">\r\n");
      out.write("			<a href=\"homepage.jsp?expenseType=Medicine\"> Medicine </a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"box1 ");
      out.print( billsSelect );
      out.write("\">\r\n");
      out.write("			<a href=\"homepage.jsp?expenseType=Bills\"> Bills </a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"box1 ");
      out.print( otherSelect );
      out.write("\">\r\n");
      out.write("			<a href=\"homepage.jsp?expenseType=Others\"> Other </a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Button trigger modal -->\r\n");
      out.write("<div class=\"container custom-border mt-5 p-0\">\r\n");
      out.write("\r\n");
      out.write("	<div class=\"p-2\">\r\n");
      out.write("		<h4>Expense Report</h4>\r\n");
      out.write("	</div>\r\n");
      out.write("		\r\n");
      out.write("	<div>\r\n");
      out.write("		<table class=\"table\">\r\n");
      out.write("		  <thead class=\"thead-dark\">\r\n");
      out.write("		    <tr>\r\n");
      out.write("		      <th scope=\"col\">#</th>\r\n");
      out.write("		      <th scope=\"col\">Expense Date</th>\r\n");
      out.write("		      <th scope=\"col\">Expense Type</th>\r\n");
      out.write("		      <th scope=\"col\">Expense Description</th>\r\n");
      out.write("		      <th scope=\"col\">Amount</th>\r\n");
      out.write("		      <th scope=\"col\">Action</th>\r\n");
      out.write("		    </tr>\r\n");
      out.write("		  </thead>\r\n");
      out.write("		  <tbody>\r\n");
      out.write("		    ");
 int i = 1;
		    for(Expense e:eList){ 
      out.write("\r\n");
      out.write("		    <tr>\r\n");
      out.write("		      <th scope=\"row\">");
      out.print(i);
      out.write("</th>\r\n");
      out.write("		      <td>");
      out.print(e.getDate() );
      out.write("</td>\r\n");
      out.write("		      <td>");
      out.print(e.getType() );
      out.write("</td>\r\n");
      out.write("		      <td>");
      out.print(e.getDesc() );
      out.write("</td>\r\n");
      out.write("		      <td>");
      out.print(e.getAmount() );
      out.write("</td>\r\n");
      out.write("		      <td><a href=\"\" class=\"link1\" data-toggle=\"modal\" data-target=\"#delete_list\" onclick=\"addToModal(");
      out.print(e.getId() );
      out.write(',');
      out.write('\'');
      out.print(expenseType);
      out.write("')\">Delete</a></td>\r\n");
      out.write("		    </tr>\r\n");
      out.write("		    ");
 i++;} 
      out.write("\r\n");
      out.write("		  </tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
 if (eList.size() !=0){
      out.write("\r\n");
      out.write("	<div class=\"m-4\">\r\n");
      out.write("		<div class=\"progress\" style=\"height: 35px; font-weight: bolder\">\r\n");
      out.write("		  <div class=\"progress-bar\" role=\"progressbar\" style=\"width: ");
      out.print( ((travel/size)*100.0) );
      out.write("%\">Travel (");
      out.print( (int)((travel/size)*100.0)  );
      out.write(") %</div>\r\n");
      out.write("		  <div class=\"progress-bar bg-success\" role=\"progressbar\" style=\"width: ");
      out.print( ((food/size)*100.0) );
      out.write("%\">Food (");
      out.print( (int)((food/size)*100.0) );
      out.write(") %</div>\r\n");
      out.write("		  <div class=\"progress-bar bg-danger\" role=\"progressbar\" style=\"width: ");
      out.print( ((medicine/size)*100.0) );
      out.write("%\">Medicines (");
      out.print( (int)((medicine/size)*100.0) );
      out.write(") %</div>\r\n");
      out.write("		  <div class=\"progress-bar bg-warning\" role=\"progressbar\" style=\"width: ");
      out.print( ((bills/size)*100.0) );
      out.write("%\">Bills (");
      out.print( (int)((bills/size)*100.0) );
      out.write(") %</div>\r\n");
      out.write("		  <div class=\"progress-bar bg-secondary\" role=\"progressbar\" style=\"width: ");
      out.print( ((others/size)*100.0) );
      out.write("%\">Other (");
      out.print( (int)((others/size)*100.0) );
      out.write(") %</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("	<div class=\"m-2 text-right\">\r\n");
      out.write("		<button type=\"button\" class=\"btn btn-danger btn2\" onclick=\"showAddExpense()\">Add Expense</button>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container custom-border mt-5 p-5 expense\">\r\n");
      out.write("<div>\r\n");
      out.write("<h4>Add Expense </h4>\r\n");
      out.write("</div>\r\n");
      out.write("      <form ACTION=\"HomepageServlet\" method=\"post\">\r\n");
      out.write("      \r\n");
      out.write("     \r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("     \r\n");
      out.write("      <label for=\"expDate\" class=\"row-sm-2 col-form-label\">Expense Date:</label>\r\n");
      out.write("      \r\n");
      out.write("        <input type=\"date\" id=\"expDate\"class=\"form-control\" name=\"expDate\" placeholder=\"Enter Expense Date\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("        <label for=\"expDesc\" class=\"row-sm-2 col-form-label\">Expense Description:</label>\r\n");
      out.write("        <textarea name=\"expDesc\" id=\"expDesc\" class=\"form-control\" rows=\"5\" placeholder=\"Enter Expense Description\" required></textarea>\r\n");
      out.write("      </div>\r\n");
      out.write("					<div class=\"row \">\r\n");
      out.write("						<div class=\"form-group col-md-6\">\r\n");
      out.write("							<label for=\"expType\">Expense Type:</label> \r\n");
      out.write("							<select id=\"expType\" class=\"form-control\" name=\"expType\">\r\n");
      out.write("								<option selected>Travel</option>\r\n");
      out.write("								<option>Food</option>\r\n");
      out.write("								<option>Medicine</option>\r\n");
      out.write("								<option>Bills</option>\r\n");
      out.write("								<option>Others</option>\r\n");
      out.write("							</select>\r\n");
      out.write("					</div>\r\n");
      out.write("							<div class=\"form-group col-md-6\">\r\n");
      out.write("								<label for=\"total\" >Total:</label>\r\n");
      out.write("								<input type=\"number\" min=\"1\" class=\"form-control\" id=\"total\"\r\n");
      out.write("									name=\"total\" placeholder=\"Total Expense\" required>\r\n");
      out.write("							</div>\r\n");
      out.write("						\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("	<div class=\" align-center float-right\">\r\n");
      out.write("        <button type=\"reset\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Clear</button>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-danger\" onclick=\"makeAddExpenseDisappear()\">Submit</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("       </form>\r\n");
      out.write("       </div>\r\n");
      out.write("      \r\n");
      out.write("      </div>\r\n");
      out.write("     \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <!-- Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"delete_list\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header bg-color text-white\">\r\n");
      out.write("        <h3 class=\"modal-title\" id=\"exampleModalLabel\">Warning</h3>\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <form action=\"DeleteExpenseServlet\" method=\"get\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        <div id=\"list-body\">\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("        <h5>Are you sure you want to delete !!!</h5>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-danger\" >Delete</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write(" 	\r\n");
      out.write("		   		\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
}
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
