<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/register-user.css">
</head>
<body>
	<div class="wrapper">
		<div class="lable-register">
			<p>USER DETAIL</p>
		</div>
		<p id="error">${message }</p>
		<div class="div-register">
			<form
				action="<%=request.getContextPath()%>/register"
				method="post" onsubmit="return validateRegister()"
				name="frm-register">	
				<table id="tbl-register">
					<tr>
						<td>First Name<span>*</span></td>
						<td><input type="text" id="firstName" name="firstName"
							placeholder="Enter first name"></td>
					</tr>
					<tr>
						<td>Last Name<span>*</span></td>
						<td><input type="text" id="lastName" name="lastName"
							placeholder="Enter last name"></td>
					</tr>
					<tr>
						<td>Email<span>*</span></td>
						<td><input type="email" id="email" name="email"
							placeholder="Enter email"></td>
					</tr>
					<tr>
						<td>User Name<span>*</span></td>
						<td><input type="text" id="userName" name="userName"
							placeholder="Enter user name"></td>
					</tr>
					<tr>
						<td>Password<span>*</span></td>
						<td><input type="password" id="password" name="password"
							placeholder="Enter passsword"></td>
					</tr>
					<tr>
						<td>Confirm Password<span>*</span></td>
						<td><input type="password" id="confirmpassword"
							name="confirmpassword " placeholder="Enter password again"></td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit" name="register">Register</button></td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
		<p class="lable-result">User List</p>
		<div class="div-result">
			<table class="tbl-result" id="tbl-result" border="1">
				<thead></thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/register-user.js"></script>
</body>
</html>