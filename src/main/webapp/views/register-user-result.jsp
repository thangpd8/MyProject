<%@page import="com.fa.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User Result</title>
</head>
<body>
	<% User user = (User)request.getAttribute("userRegister");%>
	<% if(user != null){ %>
	 You have entered bolow details:<br> 
	 First Name:<%=user.getFirstName() %><br> 
	 Last Name:<%=user.getLastName() %><br>
	 Email:<%=user.getEmail() %><br> 
	 User Name:<%=user.getUserName() %><br> 
	 Password:<%=user.getPassword() %><br>
	<%
	}
	%>
</body>
</html>