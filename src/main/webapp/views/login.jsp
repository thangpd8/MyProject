<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/login.css">
</head>
<body>
<div class="wrapper">
		<div class="lable-register">
			<p>LOGIN</p>
		</div>
		<p id="error">${loginFail}</p>
		<div class="div-register">
			<form action="<%=request.getContextPath()%>/login" method="post"
				onsubmit="return validateRegister()" name="frm-register">
				<table id="tbl-register">
					<tr>
						<td>User Name<span>*</span></td>
						<td><input type="text" id="userName" name="userName"
							placeholder="Enter userName "></td>
					</tr>
					<tr>
						<td>Password<span>*</span></td>
						<td><input type="text" id="password" name="password"
							placeholder="Enter password "></td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit" name="register">Login</button> <a
							class="button1" href="<%=request.getContextPath()%>/register">Click here to register</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>